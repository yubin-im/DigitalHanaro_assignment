package com.assignment.back_assignment.controller;

import com.assignment.back_assignment.adminDto.AdminLoginReqDTO;
import com.assignment.back_assignment.adminDto.MemberResDTO;
import com.assignment.back_assignment.service.CompanyMemberAdminService;
import com.assignment.back_assignment.service.CompanyMemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminApiController {
    final private CompanyMemberAdminService companyMemberAdminService;
    final private CompanyMemberService companyMemberService;

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
}
