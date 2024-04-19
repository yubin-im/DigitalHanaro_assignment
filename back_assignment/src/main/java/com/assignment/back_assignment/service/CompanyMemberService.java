package com.assignment.back_assignment.service;

import com.assignment.back_assignment.adminDto.MemberResDTO;
import com.assignment.back_assignment.dto.JoinReqDTO;
import com.assignment.back_assignment.entity.CompanyMember;
import com.assignment.back_assignment.repository.CompanyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    // 로그인 기능
    @Transactional
    public String login(String memberId, String memberPw) {
        CompanyMember memberMatchId = companyMemberRepository.findCompanyMemberByMemberId(memberId);
        CompanyMember companyMember = companyMemberRepository.findCompanyMemberByMemberIdAndMemberPw(memberId, memberPw);

        if(memberMatchId == null) {
            return "아이디가 존재하지 않습니다.";
        } else if (!memberPw.equals(memberMatchId.getMemberPw())) {
            return "비밀번호가 맞지 않습니다.";
        } else if (memberId.equals(companyMember.getMemberId()) && memberPw.equals(companyMember.getMemberPw())) {
            return "로그인이 완료되었습니다!";
        } else {
            return "아이디가 존재하지 않습니다.";
        }
    }

    // 회원목록 전체 조회
    @Transactional
    public List<MemberResDTO> memberList() {
        List<CompanyMember> companyMemberList = companyMemberRepository.findAll();

        // CompanyMember Entity -> MemberListResDTO
        return companyMemberList.stream()
                .map(this::convertToMemberListResDTO)
                .collect(Collectors.toList());
    }

    // CompanyMember Entity -> MemberListResDTO
    private MemberResDTO convertToMemberListResDTO(CompanyMember companyMember) {
        return MemberResDTO.builder()
                .memberId(companyMember.getMemberId())
                .memberName(companyMember.getMemberName())
                .memberEmail(companyMember.getMemberEmail())
                .memberBirthDate(companyMember.getMemberBirthDate())
                .memberJoinDate(companyMember.getMemberJoinDate())
                .build();
    }

    // 회원목록 검색 기능
    @Transactional
    public List<MemberResDTO> searchMember(String searchType, String searchText) {
        List<CompanyMember> companyMemberList;

        if("id".equals(searchType)) {
            companyMemberList = companyMemberRepository.findByMemberIdContaining(searchText);
        } else if ("name".equals(searchType)) {
            companyMemberList = companyMemberRepository.findByMemberNameContaining(searchText);
        } else if ("email".equals(searchType)) {
            companyMemberList = companyMemberRepository.findByMemberEmailContaining(searchText);
        } else {
            companyMemberList = companyMemberRepository.findByMemberIdOrMemberNameOrMemberEmailContaining(searchText);
        }

        // CompanyMember Entity -> MemberListResDTO
        return companyMemberList.stream()
                .map(this::convertToMemberListResDTO)
                .collect(Collectors.toList());
    }

    // 회원목록 정렬 기능
    @Transactional
    public List<MemberResDTO> sortMembers(String sortType, String sortOption) {
        List<CompanyMember> companyMemberList = null;

        if("memberId".equals(sortOption)) {
            if("ASC".equals(sortType)) {
                companyMemberList = companyMemberRepository.findAllByOrderByMemberIdAsc();
            } else {
                companyMemberList = companyMemberRepository.findAllByOrderByMemberIdDesc();
            }
        } else if ("memberJoinDate".equals(sortOption)) {
            if("ASC".equals(sortType)) {
                companyMemberList = companyMemberRepository.findAllByOrderByMemberJoinDateAsc();
            } else {
                companyMemberList = companyMemberRepository.findAllByOrderByMemberJoinDateDesc();
            }
        }

        // CompanyMember Entity -> MemberListResDTO
        return companyMemberList.stream()
                .map(this::convertToMemberListResDTO)
                .collect(Collectors.toList());
    }
}
