package com.assignment.back_assignment.repository;

import com.assignment.back_assignment.entity.CompanyQna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyQnaRepository extends JpaRepository<CompanyQna, Long> {
}
