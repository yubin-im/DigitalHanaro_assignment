package com.assignment.back_assignment.service;

import com.assignment.back_assignment.entity.CompanyMemberAdmin;
import com.assignment.back_assignment.repository.CompanyMemberAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyMemberAdminService {
    final private CompanyMemberAdminRepository companyMemberAdminRepository;

    // 관리자 로그인 기능
    @Transactional
    public String adminLogin(String memberId, String memberPw) {
        CompanyMemberAdmin adminMemberMatchId = companyMemberAdminRepository.findCompanyMemberAdminByMemberId(memberId);
        CompanyMemberAdmin companyMemberAdmin = companyMemberAdminRepository.findCompanyMemberAdminByMemberIdAndMemberPw(memberId, memberPw);

        if(adminMemberMatchId == null) {
            return "아이디가 존재하지 않습니다.";
        } else if (!memberPw.equals(adminMemberMatchId.getMemberPw())) {
            return "비밀번호가 맞지 않습니다.";
        } else if (memberId.equals(companyMemberAdmin.getMemberId()) && memberPw.equals(companyMemberAdmin.getMemberPw())) {
            return "로그인이 완료되었습니다!";
        } else {
            return "아이디가 존재하지 않습니다.";
        }
    }
}
