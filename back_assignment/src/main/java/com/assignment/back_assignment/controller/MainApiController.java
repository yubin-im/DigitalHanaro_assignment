package com.assignment.back_assignment.controller;

import com.assignment.back_assignment.dto.*;
import com.assignment.back_assignment.entity.CompanyMember;
import com.assignment.back_assignment.entity.CompanyNotice;
import com.assignment.back_assignment.service.CompanyMemberService;
import com.assignment.back_assignment.service.CompanyNoticeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainApiController {
    final private CompanyMemberService companyMemberService;
    final private CompanyNoticeService companyNoticeService;

    // 회원가입 기능
    @PostMapping("/member/join-action")
    @ResponseBody
    public CompanyMember join(@RequestBody JoinReqDTO joinReqDTO) {
        CompanyMember companyMember = companyMemberService.join(joinReqDTO);
        return companyMember;
    }

    // 아이디 중복 확인 기능
    @PostMapping("/check-duplicate-id")
    @ResponseBody
    public Map<String, Boolean> checkIdDuplicate(@RequestBody Map<String, String> idMap) {
        String memberId = idMap.get("memberId");
        boolean checkIdDup = companyMemberService.checkIdDuplicate(memberId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("duplicate", checkIdDup);
        return response;
    }

    // 아이디 찾기 기능
    @PostMapping("/findId-action")
    @ResponseBody
    public String findId(@RequestBody FindIdReqDTO findIdReqDTO) {
        String memberName = findIdReqDTO.getMemberName();
        String memberEmail = findIdReqDTO.getMemberEmail();

        String findMemberId = companyMemberService.findId(memberName, memberEmail);

        if (findMemberId != "null") {
            return "회원님의 아이디는 " + findMemberId + "입니다.";
        } else {
            return "아이디를 찾을 수 없습니다.";
        }
    }

    // 비밀번호 찾기 기능
    @PostMapping("/findPw-action")
    @ResponseBody
    public String findPw(@RequestBody FindPwReqDTO findPwReqDTO) {
        String memberName = findPwReqDTO.getMemberName();
        String memberId = findPwReqDTO.getMemberId();
        String memberEmail = findPwReqDTO.getMemberEmail();

        String findMemberPw = companyMemberService.findPw(memberName, memberId, memberEmail);

        if(findMemberPw != "null") {
            return "회원님의 암호는 " + findMemberPw + " 입니다.";
        } else {
            return "비밀번호를 찾을 수 없습니다.";
        }
    }

    // 로그인 기능
    @PostMapping("/login-action")
    @ResponseBody
    public String login(@RequestBody LoginReqDTO loginReqDTO, HttpSession session) {
        String result = companyMemberService.login(loginReqDTO.getMemberId(), loginReqDTO.getMemberPw());
        if (result.equals("로그인이 완료되었습니다!")) {
            session.setAttribute("memberId", loginReqDTO.getMemberId());
        }
        return result;
    }

    // 로그아웃 기능
    @PostMapping("/logout-action")
    @ResponseBody
    public String logout(HttpSession session) {
        session.setAttribute("userId", null);
        session.invalidate();

        String message = "로그아웃 되었습니다!";
        return message;
    }

    // 공지사항 전체 조회
    @PostMapping("/community/community01")
    @ResponseBody
    public List<CompanyNoticeDTO> announce() {
        List<CompanyNoticeDTO> companyNoticeList = companyNoticeService.findAll();

        return companyNoticeList;
    }

    // 공지사항 상세 조회
    @PostMapping("/community/community01_1")
    @ResponseBody
    public NoticeDetailResDTO announceDetail(@RequestBody Map<String, Long> noticeIdMap) {
        Long noticeIdx = noticeIdMap.get("noticeIdx");
        CompanyNotice companyNotice = companyNoticeService.findById(noticeIdx);

        // Entity -> DTO로 변환
        NoticeDetailResDTO noticeDetailResDTO = NoticeDetailResDTO.builder()
                .noticeIdx(companyNotice.getNoticeIdx())
                .noticeTitle(companyNotice.getNoticeTitle())
                .noticeContent(companyNotice.getNoticeContent())
                .noticeDate(companyNotice.getNoticeDate())
                .build();

        return noticeDetailResDTO;
    }

}
