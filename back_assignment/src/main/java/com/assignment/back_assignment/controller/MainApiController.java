package com.assignment.back_assignment.controller;

import com.assignment.back_assignment.dto.*;
import com.assignment.back_assignment.entity.CompanyMember;
import com.assignment.back_assignment.entity.CompanyNotice;
import com.assignment.back_assignment.entity.CompanyOne2one;
import com.assignment.back_assignment.service.CompanyMemberService;
import com.assignment.back_assignment.service.CompanyNoticeService;
import com.assignment.back_assignment.service.CompanyOne2oneService;
import com.assignment.back_assignment.service.CompanyQnaService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MainApiController {
    final private CompanyMemberService companyMemberService;
    final private CompanyNoticeService companyNoticeService;
    final private CompanyOne2oneService companyOne2oneService;
    final private CompanyQnaService companyQnaService;

    // 회원가입 기능
    @PostMapping("/member/join-action")
    public CompanyMember join(@RequestBody JoinReqDTO joinReqDTO) {
        CompanyMember companyMember = companyMemberService.join(joinReqDTO);
        return companyMember;
    }

    // 아이디 중복 확인 기능
    @PostMapping("/check-duplicate-id")
    public Map<String, Boolean> checkIdDuplicate(@RequestBody Map<String, String> idMap) {
        String memberId = idMap.get("memberId");
        boolean checkIdDup = companyMemberService.checkIdDuplicate(memberId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("duplicate", checkIdDup);
        return response;
    }

    // 아이디 찾기 기능
    @PostMapping("/findId-action")
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
    public String login(@RequestBody LoginReqDTO loginReqDTO, HttpSession session) {
        String result = companyMemberService.login(loginReqDTO.getMemberId(), loginReqDTO.getMemberPw());
        if (result.equals("로그인이 완료되었습니다!")) {
            session.setAttribute("memberId", loginReqDTO.getMemberId());
        }
        return result;
    }

    // 로그아웃 기능
    @PostMapping("/logout-action")
    public String logout(HttpSession session) {
        session.setAttribute("userId", null);
        session.invalidate();

        String message = "로그아웃 되었습니다!";
        return message;
    }

    // 공지사항 전체 조회
    @PostMapping("/community/community01")
    public List<CompanyNoticeDTO> announce() {
        List<CompanyNoticeDTO> companyNoticeList = companyNoticeService.findAll();

        return companyNoticeList;
    }

    // 공지사항 상세 조회
    @PostMapping("/community/community01_1")
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

    // 공지사항 검색 기능
    @PostMapping("/community/search")
    public List<CompanyNoticeDTO> searchNotices(@RequestBody SearchNoticesReqDTO searchNoticesReqDTO) {
        String searchType = searchNoticesReqDTO.getSearchType();
        String searchText = searchNoticesReqDTO.getSearchText();

        List<CompanyNoticeDTO> companyNoticeList = companyNoticeService.searchNotices(searchType, searchText);
        return companyNoticeList;
    }

    // 1대1 문의 작성 기능
    @PostMapping("/customer/writeOne2one-action")
    public CompanyOne2one writeOne2one(@RequestBody WriteOne2oneReqDTO writeOne2oneReqDTO) {
        CompanyOne2one companyOne2one = companyOne2oneService.writeOne2one(writeOne2oneReqDTO);
        return companyOne2one;
    }

    // 묻고답하기 전체 조회
    @PostMapping("/customer/customer02")
    public List<CompanyQnaDTO> qnaList() {
        List<CompanyQnaDTO> companyQnaList = companyQnaService.findAll();

        return companyQnaList;
    }

    // 묻고답하기 상세 조회
    @PostMapping("/customer/customer02_4")
    public CompanyQnaDTO qnaDetail(@RequestBody Map<String, Long> qnaIdxMap) {
        Long qnaIdx = qnaIdxMap.get("qnaIdx");
        CompanyQnaDTO companyQnaDTO = companyQnaService.findById(qnaIdx);

        return companyQnaDTO;
    }

    // 묻고답하기 상세- 비밀번호 확인
    @PostMapping("/check-qnaPw")
    public CheckQnaPwResDTO CheckQnaPw(@RequestBody CheckQnaPwReqDTO checkQnaPwReqDTO) {
        Long qnaIdx = checkQnaPwReqDTO.getQnaIdx();
        String qnaPw = checkQnaPwReqDTO.getQnaPw();
        boolean CheckQnaPw = companyQnaService.CheckQnaPw(qnaIdx, qnaPw);

        CheckQnaPwResDTO checkQnaPwRes = CheckQnaPwResDTO.builder()
                .CheckQnaPw(CheckQnaPw)
                .qnaIdx(qnaIdx)
                .build();

        return checkQnaPwRes;
    }

    // 묻고답하기 검색 기능
    @PostMapping("/customer/customer02/search")
    public List<CompanyQnaDTO> searchQnas(@RequestBody SearchQnasReqDTO searchQnasReqDTO) {
        String searchType = searchQnasReqDTO.getSearchType();
        String searchText = searchQnasReqDTO.getSearchText();

        List<CompanyQnaDTO> searchQnaList = companyQnaService.searchQnas(searchType, searchText);
        return searchQnaList;
    }
}
