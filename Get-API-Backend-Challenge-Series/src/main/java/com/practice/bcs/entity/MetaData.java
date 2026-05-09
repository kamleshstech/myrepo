package com.practice.bcs.entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "metadata_bcs_tbl")
@Data
public class MetaData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long metaDataId;
	private String description;
	private String vendor;
	private Instant uploadDt;
}
