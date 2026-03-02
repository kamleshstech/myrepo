package com.practice.aws.s3.dto;

import lombok.Data;

@Data
public class UploadedPartDto {
    private int partNumber;
    private String eTag;
}