package com.assignment.back_assignment.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyQnaDTO {
    private Long qnaIdx;
    private String qnaName;
    private String qnaPw;
    private String qnaTitle;
    private String qnaContent;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate qnaDate;
}
