package com.mvn_git.study.requests;

import java.util.HashMap;
import java.util.Map;

//import org.hibernate.annotations.processing.Pattern;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public abstract class BaseRequest {
	@Min(value = 0, message = "Page number cannot be negative")
    private int pageNumber = 0;

    @Min(value = 1, message = "Page size must be at least 1")
    private int pageSize = 10;

    @NotBlank(message = "SortBy field cannot be blank")
    private String sortBy = "id";

    @Pattern(regexp = "ASC|DESC", message = "Sort direction must be ASC or DESC")
    private String sortDirection = "ASC";

    @Size(max = 10, message = "Maximum 10 filters allowed")
    private Map<@NotBlank(message = "Filter key cannot be blank") String,
                @NotBlank(message = "Filter value cannot be blank") String> filters = new HashMap<>();

   

    // Pagination
    public int getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        if (pageNumber < 0) {
            throw new IllegalArgumentException("Page number cannot be negative");
        }
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        if (pageSize <= 0) {
            throw new IllegalArgumentException("Page size must be greater than zero");
        }
        this.pageSize = pageSize;
    }

    // Sorting
    public String getSortBy() {
        return sortBy;
    }
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }
    public void setSortDirection(String sortDirection) {
        if (!sortDirection.equalsIgnoreCase("ASC") && !sortDirection.equalsIgnoreCase("DESC")) {
            throw new IllegalArgumentException("Sort direction must be ASC or DESC");
        }
        this.sortDirection = sortDirection.toUpperCase();
    }

    // Filtering
    public Map<String, String> getFilters() {
        return filters;
    }
    public void setFilters(Map<String, String> filters) {
        this.filters = filters;
    }
}

