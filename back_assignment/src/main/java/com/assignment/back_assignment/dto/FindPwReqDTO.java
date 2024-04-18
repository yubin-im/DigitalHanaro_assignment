package com.assignment.back_assignment.dto;

import lombok.Data;

@Data
public class FindPwReqDTO {
    private String memberName;
    private String memberId;
    private String memberEmail;
}
