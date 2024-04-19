package com.assignment.back_assignment.adminDto;

import lombok.Getter;

@Getter
public class SortMemberReqDTO {
    private String sortType;  // 오름차순 or 내림차순
    private String sortOption;  // memberId or memberJoinDate
}
