package com.assignment.back_assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "company_notice")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyNotice {
    @Id
    @GeneratedValue
    private Long noticeIdx;

    @Column(name = "notice_title")
    private String noticeTitle;

    @Column(name = "notice_content")
    private String noticeContent;

    @Column(name = "notice_member_id")
    private String noticeMemberId;

    @Column(name = "notice_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate noticeDate;
}
