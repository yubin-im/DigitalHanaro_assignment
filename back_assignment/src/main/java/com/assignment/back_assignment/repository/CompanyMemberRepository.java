package com.assignment.back_assignment.repository;

import com.assignment.back_assignment.entity.CompanyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMemberRepository extends JpaRepository<CompanyMember, Long> {
    // 아이디 중복 확인 기능
    boolean existsByMemberId(String memberId);

    // 아이디 찾기 기능
    CompanyMember findCompanyMemberByMemberNameAndMemberEmail(String memberName, String memberEmail);

    // 비밀번호 찾기 기능
    CompanyMember findCompanyMemberByMemberNameAndMemberIdAndMemberEmail(String memberName, String memberId, String memberEmail);

    // 로그인 기능
    CompanyMember findCompanyMemberByMemberIdAndMemberPw(String memberId, String memberPw);
    CompanyMember findCompanyMemberByMemberId(String memberId);

    // 회원목록 검색 기능 (아이디, 이름, 이메일, 전체)
    List<CompanyMember> findByMemberIdContaining(String searchText);
    List<CompanyMember> findByMemberNameContaining(String searchText);
    List<CompanyMember> findByMemberEmailContaining(String searchText);
    @Query("SELECT m FROM CompanyMember m WHERE m.memberId LIKE %:searchText% " +
            "OR m.memberName LIKE %:searchText% " +
            "OR m.memberEmail LIKE %:searchText%")
    List<CompanyMember> findByMemberIdOrMemberNameOrMemberEmailContaining(String searchText);

}
