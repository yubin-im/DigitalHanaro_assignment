package com.assignment.back_assignment.adminDto;

import lombok.Getter;

@Getter
public class SortNoticesReqDTO {
    private String sortType;  // 오름차순 or 내림차순
    private String sortOption;  // noticeMemberId or noticeDate
}
