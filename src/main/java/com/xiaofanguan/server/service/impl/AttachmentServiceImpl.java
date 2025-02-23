package com.xiaofanguan.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.common.WebContext;
import com.xiaofanguan.server.mapper.AttachmentMapper;
import com.xiaofanguan.server.pojo.Attachment;
import com.xiaofanguan.server.service.AttachmentService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public ResponseResult<Attachment> uploadFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String fileType = file.getContentType();
            long fileSize = file.getSize();
            String base64Content = Base64.encodeBase64String(file.getBytes());

            Attachment attachment = new Attachment();
            attachment.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            attachment.setFileName(fileName);
            attachment.setFileType(fileType);
            attachment.setFileSize(fileSize);
            attachment.setBase64Content(base64Content);
            attachment.setCreateTime(LocalDateTime.now());
            attachment.setCreatedBy(WebContext.getUserId());

            attachmentMapper.insert(attachment);
            return ResponseResult.success(attachment);
        } catch (IOException e) {
            return ResponseResult.error(500, "文件上传失败");
        }
    }

    @Override
    public ResponseResult<Attachment> downloadFile(String id, HttpServletResponse response) {
        Attachment attachment = attachmentMapper.selectById(id);
        if (attachment == null) {
            return ResponseResult.error(404, "文件未找到");
        }

        try {
            // 设置响应头
            response.setContentType(attachment.getFileType());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + attachment.getFileName() + "\"");
            response.setContentLengthLong(attachment.getFileSize());

            // 将 Base64 内容解码并写入响应流
            byte[] fileBytes = Base64.decodeBase64(attachment.getBase64Content());
            response.getOutputStream().write(fileBytes);
            response.getOutputStream().flush();
            response.getOutputStream().close();

            return ResponseResult.success(attachment);
        } catch (IOException e) {
            return ResponseResult.error(500, "文件下载失败");
        }
    }
}