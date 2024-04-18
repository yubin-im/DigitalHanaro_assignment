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
}
