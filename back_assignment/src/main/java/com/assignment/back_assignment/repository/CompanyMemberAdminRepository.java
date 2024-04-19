package com.assignment.back_assignment.repository;

import com.assignment.back_assignment.entity.CompanyMemberAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyMemberAdminRepository extends JpaRepository<CompanyMemberAdmin, Long> {
    // 관리자 로그인 기능
    CompanyMemberAdmin findCompanyMemberAdminByMemberIdAndMemberPw(String memberId, String memberPw);
    CompanyMemberAdmin findCompanyMemberAdminByMemberId(String memberId);
}
