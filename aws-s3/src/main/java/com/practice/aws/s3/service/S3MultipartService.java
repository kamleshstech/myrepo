package com.practice.aws.s3.service;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.practice.aws.s3.dto.CompleteUploadRequest;
import com.practice.aws.s3.entity.FileMetadata;
import com.practice.aws.s3.repository.FileMetadataRepository;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.CompletedMultipartUpload;
import software.amazon.awssdk.services.s3.model.CompletedPart;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedUploadPartRequest;
import software.amazon.awssdk.services.s3.presigner.model.UploadPartPresignRequest;

@Service
@RequiredArgsConstructor
public class S3MultipartService {
	@Autowired
    private final S3Client s3Client;
	@Autowired
    private final S3Presigner presigner;
	@Autowired
    private final FileMetadataRepository repository;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    // 1️⃣ Initiate Upload
    public String initiateUpload(String fileName, String contentType) {

        CreateMultipartUploadRequest request =
                CreateMultipartUploadRequest.builder()
                        .bucket(bucketName)
                        .key(fileName)
                        .contentType(contentType)
                        .build();

        String uploadId = s3Client
                .createMultipartUpload(request)
                .uploadId();

        FileMetadata meta = new FileMetadata();
        meta.setFileName(fileName);
        meta.setS3Key(fileName);
        meta.setStatus("INITIATED");
        repository.save(meta);

        return uploadId;
    }

    // 2️⃣ Presigned URL for part upload
    public String generatePresignedUrl(
            String fileName,
            String uploadId,
            int partNumber) {

        UploadPartRequest uploadPartRequest =
                UploadPartRequest.builder()
                        .bucket(bucketName)
                        .key(fileName)
                        .uploadId(uploadId)
                        .partNumber(partNumber)
                        .build();

        PresignedUploadPartRequest presignedRequest =
                presigner.presignUploadPart(
                        UploadPartPresignRequest.builder()
                                .uploadPartRequest(uploadPartRequest)
                                .signatureDuration(Duration.ofMinutes(10))
                                .build());

        return presignedRequest.url().toString();
    }

    // 3️⃣ Complete Upload
    public void completeUpload(CompleteUploadRequest request) {

        List<CompletedPart> completedParts =
                request.getParts().stream()
                        .map(p -> CompletedPart.builder()
                                .partNumber(p.getPartNumber())
                                .eTag(p.getETag())
                                .build())
                        .toList();

        CompletedMultipartUpload completedUpload =
                CompletedMultipartUpload.builder()
                        .parts(completedParts)
                        .build();

        CompleteMultipartUploadRequest completeRequest =
                CompleteMultipartUploadRequest.builder()
                        .bucket(bucketName)
                        .key(request.getFileName())
                        .uploadId(request.getUploadId())
                        .multipartUpload(completedUpload)
                        .build();

        s3Client.completeMultipartUpload(completeRequest);

        repository.findAll().forEach(f -> {
            if (f.getFileName().equals(request.getFileName())) {
                f.setStatus("COMPLETED");
                repository.save(f);
            }
        });
    }
}