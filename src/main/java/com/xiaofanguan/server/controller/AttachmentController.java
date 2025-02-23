package com.xiaofanguan.server.controller;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @PostMapping("/upload")
    public ResponseResult<?> uploadFile(@RequestParam("file") MultipartFile file) {
        return attachmentService.uploadFile(file);
    }

    @GetMapping("/download/{id}")
    public ResponseResult<?> downloadFile(@PathVariable String id, HttpServletResponse response) {
        return attachmentService.downloadFile(id, response);
    }
}