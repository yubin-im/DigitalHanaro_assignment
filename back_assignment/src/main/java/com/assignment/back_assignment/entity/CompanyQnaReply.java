package com.assignment.back_assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "company_qna_reply")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyQnaReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qnaReplyIdx;

    @Column(name = "qna_reply_content")
    private String qnaReplyContent;

    @Column(name = "qna_reply_name")
    private String qnaReplyName;

    @Column(name = "qna_reply_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate qnaReplyDate;

    @Column(name = "qna_reply_qna_idx")
    private int qnaReplyQnaIdx;
}
