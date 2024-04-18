package com.assignment.back_assignment.repository;

import com.assignment.back_assignment.entity.CompanyNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyNoticeRepository extends JpaRepository<CompanyNotice, Long> {
    // 공지사항 검색 기능
    List<CompanyNotice> findByNoticeTitleContaining(String searchText);
    List<CompanyNotice> findByNoticeContentContaining(String searchText);
}
