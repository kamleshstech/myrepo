package com.practice.aws.s3.dto;

import java.util.List;

import lombok.Data;

@Data
public class CompleteUploadRequest {
    private String uploadId;
    private String fileName;
    private List<UploadedPartDto> parts;
}