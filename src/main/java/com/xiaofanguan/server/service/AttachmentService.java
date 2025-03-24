package com.xiaofanguan.server.service;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.pojo.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    ResponseResult<Attachment> uploadFile(MultipartFile file);
    ResponseResult<String> getFileUrl(String id);
    ResponseResult<Void> deleteFile(String id);
}