package com.assignment.back_assignment.repository;

import com.assignment.back_assignment.entity.CompanyNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyNoticeRepository extends JpaRepository<CompanyNotice, Long> {
    // 공지사항 검색 기능 (제목, 내용, 작성자아이디, 전체)
    List<CompanyNotice> findByNoticeTitleContaining(String searchText);
    List<CompanyNotice> findByNoticeContentContaining(String searchText);
    List<CompanyNotice> findByNoticeMemberIdContaining(String searchText);
    @Query("SELECT n FROM CompanyNotice n WHERE n.noticeTitle LIKE %:searchText% " +
            "OR n.noticeContent LIKE %:searchText% " +
            "OR n.noticeMemberId LIKE %:searchText%")
    List<CompanyNotice> findByNoticeTitleOrNoticeContentOrNoticeMemberIdContaining(String searchText);

}
