package com.xiaofanguan.server.service;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.pojo.Attachment;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface AttachmentService {
    ResponseResult<Attachment> uploadFile(MultipartFile file);

    ResponseResult<Attachment> downloadFile(String id, HttpServletResponse response);
}