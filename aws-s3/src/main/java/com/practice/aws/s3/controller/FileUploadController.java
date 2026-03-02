package com.practice.aws.s3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.aws.s3.dto.CompleteUploadRequest;
import com.practice.aws.s3.service.S3MultipartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileUploadController {

    private final S3MultipartService service;

    // Step 1: Initiate
    @PostMapping("/initiate")
    public ResponseEntity<String> initiate(
            @RequestParam String fileName,
            @RequestParam String contentType) {

        return ResponseEntity.ok(
                service.initiateUpload(fileName, contentType));
    }

    // Step 2: Get presigned URL
    @GetMapping("/presigned-url")
    public ResponseEntity<String> presignedUrl(
            @RequestParam String fileName,
            @RequestParam String uploadId,
            @RequestParam int partNumber) {

        return ResponseEntity.ok(
                service.generatePresignedUrl(fileName, uploadId, partNumber));
    }

    // Step 3: Complete upload
    @PostMapping("/complete")
    public ResponseEntity<String> complete(
            @RequestBody CompleteUploadRequest request) {

        service.completeUpload(request);
        return ResponseEntity.ok("Upload completed successfully");
    }
}