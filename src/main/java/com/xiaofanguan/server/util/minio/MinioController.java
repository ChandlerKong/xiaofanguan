package com.xiaofanguan.server.util.minio;

import com.xiaofanguan.server.common.ResponseResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/minio")
public class MinioController {

    private final MinioService minioService;

    public MinioController(MinioService minioService) {
        this.minioService = minioService;
    }

    // 上传文件
    @PostMapping("/upload")
    public ResponseResult<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String filename = minioService.uploadFile(file);
            return ResponseResult.success("File uploaded successfully! File Name: " + filename);
        } catch (Exception e) {
            return ResponseResult.error("Error: " + e.getMessage());
        }
    }

    // 获取文件 URL
    @GetMapping("/file/{filename}")
    public ResponseResult<String> getFileUrl(@PathVariable String filename) {
        try {
            String fileUrl = minioService.getFileUrl(filename);
            return ResponseResult.success(fileUrl);
        } catch (Exception e) {
            return ResponseResult.error("Error: " + e.getMessage());
        }
    }


    // 删除文件
    @DeleteMapping("/file/{filename}")
    public ResponseResult<String> deleteFile(@PathVariable String filename) {
        try {
            minioService.deleteFile(filename);
            return ResponseResult.ok("File deleted successfully!");
        } catch (Exception e) {
            return ResponseResult.error("Error: " + e.getMessage());
        }
    }
}