package com.practice.bcs.dto;



import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PaginatedResponse<T> {
	
	private List<T> items;
	private long totalElements;
	private int totalPages;
	private int currentPage;
	private int pageSize;
	boolean isFirst;
	boolean isLast;
}
