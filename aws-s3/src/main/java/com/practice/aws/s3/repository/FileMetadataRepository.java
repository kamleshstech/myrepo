package com.practice.aws.s3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.aws.s3.entity.FileMetadata;

public interface FileMetadataRepository extends JpaRepository<FileMetadata, Long>{

}
