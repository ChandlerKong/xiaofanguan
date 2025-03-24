package com.xiaofanguan.server.service.impl;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.common.WebContext;
import com.xiaofanguan.server.mapper.AttachmentMapper;
import com.xiaofanguan.server.pojo.Attachment;
import com.xiaofanguan.server.service.AttachmentService;
import com.xiaofanguan.server.util.minio.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentMapper attachmentMapper;
    
    @Autowired
    private MinioService minioService;

    @Override
    @Transactional
    public ResponseResult<Attachment> uploadFile(MultipartFile file) {
        try {
            // 上传文件到MinIO
            String minioFileName = minioService.uploadFile(file);
            
            // 保存附件信息到数据库
            Attachment attachment = new Attachment();
            attachment.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            attachment.setFileName(minioFileName);
            attachment.setCreateTime(LocalDateTime.now());
            attachment.setCreatedBy(WebContext.getUserId());

            attachmentMapper.insert(attachment);
            return ResponseResult.success(attachment);
        } catch (Exception e) {
            return ResponseResult.error(500, "文件上传失败: " + e.getMessage());
        }
    }

    @Override
    public ResponseResult<String> getFileUrl(String id) {
        try {
            Attachment attachment = attachmentMapper.selectById(id);
            if (attachment == null) {
                return ResponseResult.error(404, "文件不存在");
            }
            String url = minioService.getFileUrl(attachment.getFileName());
            return ResponseResult.success(url);
        } catch (Exception e) {
            return ResponseResult.error(500, "获取文件链接失败: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public ResponseResult<Void> deleteFile(String id) {
        try {
            Attachment attachment = attachmentMapper.selectById(id);
            if (attachment == null) {
                return ResponseResult.error(404, "文件不存在");
            }
            // 从MinIO中删除文件
            minioService.deleteFile(attachment.getFileName());
            // 从数据库中删除记录
            attachmentMapper.deleteById(id);
            return ResponseResult.success();
        } catch (Exception e) {
            return ResponseResult.error(500, "删除文件失败: " + e.getMessage());
        }
    }
}