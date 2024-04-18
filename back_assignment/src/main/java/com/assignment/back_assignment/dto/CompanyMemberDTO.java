package com.assignment.back_assignment.dto;

import com.assignment.back_assignment.entity.CompanyMember;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyMemberDTO {
    private Long memberIdx;
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
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate memberJoinDate;

    // CompanyMember DTO -> Entity 변환
    public CompanyMember toCompanyMemberEntity() {
        return CompanyMember.builder()
                .memberIdx(memberIdx)
                .memberId(memberId)
                .memberPw(memberPw)
                .memberName(memberName)
                .memberEmail(memberEmail)
                .memberEmailReceive(memberEmailReceive)
                .memberPwQuestion(memberPwQuestion)
                .memberPwAnswer(memberPwAnswer)
                .memberGender(memberGender)
                .memberBirthDate(memberBirthDate)
                .memberJoinDate(memberJoinDate)
                .build();
    }
}
