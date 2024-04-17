package com.assignment.back_assignment.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company_faq")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyFaq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long faqIdx;

    @Column(name = "faq_title")
    private String faqTitle;

    @Column(name = "faq_content")
    private String faqContent;
}
