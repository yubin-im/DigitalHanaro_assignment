package com.assignment.back_assignment.service;

import com.assignment.back_assignment.dto.JoinReqDTO;
import com.assignment.back_assignment.entity.CompanyMember;
import com.assignment.back_assignment.repository.CompanyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CompanyMemberService {
    final private CompanyMemberRepository companyMemberRepository;

    // 회원가입 기능
    @Transactional
    public CompanyMember join(JoinReqDTO joinReqDTO) {
        CompanyMember companyMember = CompanyMember.builder()
                .memberId(joinReqDTO.getMemberId())
                .memberPw(joinReqDTO.getMemberPw())
                .memberName(joinReqDTO.getMemberName())
                .memberEmail(joinReqDTO.getMemberEmail())
                .memberEmailReceive(joinReqDTO.getMemberEmailReceive())
                .memberPwQuestion(joinReqDTO.getMemberPwQuestion())
                .memberPwAnswer(joinReqDTO.getMemberPwAnswer())
                .memberGender(joinReqDTO.getMemberGender())
                .memberBirthDate(joinReqDTO.getMemberBirthDate())
                .memberJoinDate(LocalDate.now())
                .build();
        companyMemberRepository.save(companyMember);
        return companyMember;
    }

    // 아이디 중복 확인 기능
    @Transactional
    public boolean checkIdDuplicate(String memberId) {
        boolean checkIdDup = companyMemberRepository.existsByMemberId(memberId);
        return checkIdDup;
    }

    // 아이디 찾기 기능
    @Transactional
    public String findId(String memberName, String memberEmail) {
        CompanyMember companyMember = companyMemberRepository.findCompanyMemberByMemberNameAndMemberEmail(memberName, memberEmail);
        if(companyMember == null) {
            return "null";
        }
        String findMemberId = companyMember.getMemberId();

        return findMemberId;
    }

    // 비밀번호 찾기 기능
    @Transactional
    public String findPw(String memberName, String memberId, String memberEmail) {
        CompanyMember companyMember = companyMemberRepository.findCompanyMemberByMemberNameAndMemberIdAndMemberEmail(memberName, memberId, memberEmail);
        if(companyMember == null) {
            return "null";
        }
        String findMemberPw = companyMember.getMemberPw();

        return findMemberPw;
    }
}
