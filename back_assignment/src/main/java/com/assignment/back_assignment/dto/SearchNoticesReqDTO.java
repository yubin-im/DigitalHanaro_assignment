package com.assignment.back_assignment.dto;

import lombok.Data;

@Data
public class SearchNoticesReqDTO {
    private String searchType;
    private String searchText;
}
