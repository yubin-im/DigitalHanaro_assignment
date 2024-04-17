package com.assignment.back_assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "company_qna")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyQna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qnaIdx;

    @Column(name = "qna_name")
    private String qnaName;

    @Column(name = "qna_pw")
    private String qnaPw;

    @Column(name = "qna_title")
    private String qnaTitle;

    @Column(name = "qna_content")
    private String qnaContent;

    @Column(name = "qna_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate qnaDate;
}
