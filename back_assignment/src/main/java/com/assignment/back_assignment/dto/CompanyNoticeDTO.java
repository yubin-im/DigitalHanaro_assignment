package com.assignment.back_assignment.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyNoticeDTO {
    private Long noticeIdx;
    private String noticeTitle;
    private String noticeContent;
    private String noticeMemberId;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate noticeDate;

}
