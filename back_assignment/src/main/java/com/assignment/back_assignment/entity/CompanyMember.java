package com.assignment.back_assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "company_member")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberIdx;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_pw")
    private String memberPw;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_email_receive")
    private int memberEmailReceive;

    @Column(name = "member_pw_question")
    private int memberPwQuestion;

    @Column(name = "member_pw_answer")
    private String memberPwAnswer;

    @Column(name = "member_gender")
    private String memberGender;

    @Column(name = "member_birth_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate memberBirthDate;

    @Column(name = "member_join_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate memberJoinDate;
}
