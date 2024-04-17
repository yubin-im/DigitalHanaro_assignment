package com.assignment.back_assignment.repository;

import com.assignment.back_assignment.entity.CompanyFaq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyFaqRepository extends JpaRepository<CompanyFaq, Long> {
}
