package com.assignment.back_assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "company_one2one_reply")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyOne2oneReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long one2oneReplyIdx;

    @Column(name = "one2one_reply_content")
    private String one2oneReplyContent;

    @Column(name = "one2one_reply_name")
    private String one2oneReplyName;

    @Column(name = "one2one_reply_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate one2oneReplyDate;

    @Column(name = "one2one_reply_one2one_idx")
    private int one2oneReplyOne2oneIdx;
}
