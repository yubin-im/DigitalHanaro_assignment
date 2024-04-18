package com.assignment.back_assignment.repository;

import com.assignment.back_assignment.entity.CompanyOne2one;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyOne2oneRepository extends JpaRepository<CompanyOne2one, Long> {
}
