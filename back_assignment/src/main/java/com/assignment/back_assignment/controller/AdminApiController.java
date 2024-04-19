package com.assignment.back_assignment.controller;

import com.assignment.back_assignment.adminDto.*;
import com.assignment.back_assignment.dto.CompanyNoticeDTO;
import com.assignment.back_assignment.entity.CompanyMember;
import com.assignment.back_assignment.entity.CompanyNotice;
import com.assignment.back_assignment.service.CompanyMemberAdminService;
import com.assignment.back_assignment.service.CompanyMemberService;
import com.assignment.back_assignment.service.CompanyNoticeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AdminApiController {
    final private CompanyMemberAdminService companyMemberAdminService;
    final private CompanyMemberService companyMemberService;
    final private CompanyNoticeService companyNoticeService;

    // 관리자 로그인 기능
    @PostMapping("/adminLogin-action")
    @ResponseBody
    public String adminLogin(@RequestBody AdminLoginReqDTO adminLoginReqDTO, HttpSession session) {
        String memberId = adminLoginReqDTO.getMemberId();
        String memberPw = adminLoginReqDTO.getMemberPw();
        String result = companyMemberAdminService.adminLogin(memberId, memberPw);

        if(result.equals("로그인이 완료되었습니다!")) {
            session.setAttribute("memberId", memberId);
        }
        return result;
    }

    // 회원목록 전체 조회
    @PostMapping("/admin-member")
    @ResponseBody
    public List<MemberResDTO> memberList() {
        List<MemberResDTO> companyMemberList = companyMemberService.memberList();

        return companyMemberList;
    }

    // 회원목록 검색 기능
    @PostMapping("/admin-member/search")
    @ResponseBody
    public List<MemberResDTO> searchMember(@RequestBody SearchMemberReqDTO searchMemberReqDTO) {
        String searchType = searchMemberReqDTO.getSearchType();
        String searchText = searchMemberReqDTO.getSearchText();

        List<MemberResDTO> searchMemberList = companyMemberService.searchMember(searchType, searchText);
        return searchMemberList;
    }

    // 회원목록 정렬 기능
    @PostMapping("/admin-member/sort")
    @ResponseBody
    public List<MemberResDTO> sortMembers(@RequestBody SortMemberReqDTO sortMemberReqDTO) {
        String sortType = sortMemberReqDTO.getSortType();
        String sortOption = sortMemberReqDTO.getSortOption();

        List<MemberResDTO> sortMemberList = companyMemberService.sortMembers(sortType, sortOption);
        return sortMemberList;
    }

    // 회원목록 행수 조절 기능
    @PostMapping("/admin-member/changePageSize")
    @ResponseBody
    public List<CompanyMember> changeMemberListSize(@RequestBody Map<String, String> sizeMap) {
        String pageSize = sizeMap.get("pageSize");
        Page<CompanyMember> changeMemberListSize = companyMemberService.changeMemberListSize(pageSize);

        return changeMemberListSize.stream().toList();
    }

    // 공지사항 관리- 공지사항 전체 조회
    @PostMapping("/admin-notice")
    @ResponseBody
    public List<CompanyNoticeDTO> AdminAnnounceList() {
        List<CompanyNoticeDTO> companyNoticeList = companyNoticeService.findAll();

        return companyNoticeList;
    }

    // 공지사항 관리- 공지사항 검색 기능
    @PostMapping("/admin-notice/search")
    @ResponseBody
    public List<CompanyNoticeDTO> searchNotices(@RequestBody AdminSearchNoticeReqDTO adminSearchNoticeReqDTO) {
        String searchType = adminSearchNoticeReqDTO.getSearchType();
        String searchText = adminSearchNoticeReqDTO.getSearchText();

        List<CompanyNoticeDTO> searchNoticeList = companyNoticeService.adminSearchNotices(searchType, searchText);
        return searchNoticeList;
    }

    // 공지사항 관리- 공지사항 정렬 기능
    @PostMapping("/admin-notice/sort")
    @ResponseBody
    public List<CompanyNoticeDTO> sortNotices(@RequestBody SortNoticesReqDTO sortNoticesReqDTO) {
        String sortType = sortNoticesReqDTO.getSortType();
        String sortOption = sortNoticesReqDTO.getSortOption();

        List<CompanyNoticeDTO> sortNoticeList = companyNoticeService.sortNotices(sortType, sortOption);
        return sortNoticeList;
    }

    // 공지사항 관리- 공지사항 목록 행수 조절 기능
    @PostMapping("/admin-notice/changePageSize")
    @ResponseBody
    public List<CompanyNotice> changeNoticeListSize(@RequestBody Map<String, String> sizeMap) {
        String pageSize = sizeMap.get("pageSize");
        Page<CompanyNotice> changeSizeNoticeList = companyNoticeService.changeNoticeListSize(pageSize);

        return changeSizeNoticeList.stream().toList();
    }
}
