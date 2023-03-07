package com.example.employee.configuration;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;

public class MinioClientConfiguration {
    @Autowired
    MinioClient minioClient;

    public void createBucket(String bucketName) {
        try {
            boolean bucketFound = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!bucketFound) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
        } catch (Exception e) {
            // handle exception
        }
    }

}
