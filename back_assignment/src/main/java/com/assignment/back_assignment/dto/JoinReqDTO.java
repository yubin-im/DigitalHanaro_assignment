package com.assignment.back_assignment.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class JoinReqDTO {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private int memberEmailReceive;
    private int memberPwQuestion;
    private String memberPwAnswer;
    private String memberGender;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate memberBirthDate;
}
