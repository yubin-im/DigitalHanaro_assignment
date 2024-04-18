package com.assignment.back_assignment.repository;

import com.assignment.back_assignment.entity.CompanyMember;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

}
