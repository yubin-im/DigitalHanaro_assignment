package com.assignment.back_assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "company_job")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobIdx;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_content")
    private String jobContent;

    @Column(name = "job_member_id")
    private String jobMemberId;

    @Column(name = "job_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate jobDate;
}
