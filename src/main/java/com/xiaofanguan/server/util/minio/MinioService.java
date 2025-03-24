package com.xiaofanguan.server.util.minio;

import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class MinioService {

    private final MinioClient minioClient;

    @Value("${minio.bucket-name}")
    private String bucketName;

    public MinioService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    // 创建 Bucket（如果不存在）
    public void createBucket() throws Exception {
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    // 上传文件
    public String uploadFile(MultipartFile file) throws Exception {
        String filename = UUID.randomUUID() + "-" + file.getOriginalFilename();
        minioClient.putObject(
            PutObjectArgs.builder()
                .bucket(bucketName)
                .object(filename)
                .stream(file.getInputStream(), file.getSize(), -1)
                .contentType(file.getContentType())
                .build()
        );

        return filename;
    }

    // 获取文件 URL
    public String getFileUrl(String filename) throws Exception {
        return minioClient.getPresignedObjectUrl(
            GetPresignedObjectUrlArgs.builder()
                .bucket(bucketName)
                .object(filename)
                .method(Method.GET)
                .build()
        );
    }


    // 删除文件
    public void deleteFile(String filename) throws Exception {
        minioClient.removeObject(
                RemoveObjectArgs.builder()
                        .bucket(bucketName)
                        .object(filename)
                        .build()
        );
    }
}