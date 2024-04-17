package com.assignment.back_assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "company_one2one")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyOne2one {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long one2oneIdx;

    @Column(name = "one2one_name")
    private String one2oneName;

    @Column(name = "one2one_phone")
    private String one2onePhone;

    @Column(name = "one2one_email")
    private String one2oneEmail;

    @Column(name = "one2one_address")
    private String one2oneAddress;

    @Column(name = "one2one_title")
    private String one2oneTitle;

    @Column(name = "one2one_content")
    private String one2oneContent;

    @Column(name = "one2one_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate one2oneDate;
}
