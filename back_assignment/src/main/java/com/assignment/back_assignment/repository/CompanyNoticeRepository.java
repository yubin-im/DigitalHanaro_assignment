package com.assignment.back_assignment.repository;

import com.assignment.back_assignment.entity.CompanyNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyNoticeRepository extends JpaRepository<CompanyNotice, Long> {
}
