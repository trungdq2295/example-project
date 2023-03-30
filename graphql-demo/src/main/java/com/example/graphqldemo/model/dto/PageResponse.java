package com.example.graphqldemo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageResponse {

    private int pageNumber;

    private int totalPages;

    private long totalElements;

    private int pageSize;
}
