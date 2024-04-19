package com.assignment.back_assignment.adminDto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResDTO {
    private String memberId;
    private String memberName;
    private String memberEmail;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate memberBirthDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate memberJoinDate;
}
