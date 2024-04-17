package com.assignment.back_assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "company_product")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productIdx;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_content")
    private String productContent;

    @Column(name = "product_img")
    private String productImg;

    @Column(name = "product_reg_name")
    private String productRegName;

    @Column(name = "product_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate productDate;
}
