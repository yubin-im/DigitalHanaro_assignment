package com.assignment.back_assignment.controller;

import com.assignment.back_assignment.adminDto.AdminLoginReqDTO;
import com.assignment.back_assignment.service.CompanyMemberAdminService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class AdminApiController {
    final private CompanyMemberAdminService companyMemberAdminService;

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
}
