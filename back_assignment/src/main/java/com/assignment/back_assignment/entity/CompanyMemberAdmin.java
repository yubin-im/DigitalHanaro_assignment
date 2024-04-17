package com.assignment.back_assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "company_member_admin")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyMemberAdmin {
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

    @Column(name = "member_join_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate memberJoinDate;
}
