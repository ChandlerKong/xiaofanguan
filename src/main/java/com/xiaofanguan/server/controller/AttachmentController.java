package com.xiaofanguan.server.controller;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @PostMapping("/upload")
    public ResponseResult<?> uploadFile(@RequestParam("file") MultipartFile file) {
        return attachmentService.uploadFile(file);
    }
    @GetMapping("/{id}")
    public ResponseResult<?> getFileUrl(@PathVariable String id) {
        return attachmentService.getFileUrl(id);
    }
    @DeleteMapping("/{id}")
    public ResponseResult<?> deleteFile(@PathVariable String id) {
        attachmentService.deleteFile(id);
        return ResponseResult.success();
    }
}