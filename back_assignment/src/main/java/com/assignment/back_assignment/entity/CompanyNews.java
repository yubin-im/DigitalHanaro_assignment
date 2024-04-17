package com.assignment.back_assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "company_news")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsIdx;

    @Column(name = "news_title")
    private String newsTitle;

    @Column(name = "news_content")
    private String newsContent;

    @Column(name = "news_member_id")
    private String newsMemberId;

    @Column(name = "news_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate newsDate;
}
