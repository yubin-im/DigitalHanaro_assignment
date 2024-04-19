package com.assignment.back_assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminViewController {
    // 관리자 로그인 화면
    @GetMapping("/admin")
    public String viewAdminLogin() {
        return "admin/admin_login";
    }

    // 회원관리 화면
    @GetMapping("/admin-member")
    public String viewAdminMember() {
        return "admin/admin_member";
    }

    // 공지사항관리 화면
    @GetMapping("/admin-notice")
    public String viewAdminNotice() {
        return "admin/admin_notice";
    }

    // 공지사항관리- 상세 화면
    @GetMapping("/admin-notice-view")
    public String viewAdminNoticeView() {
        return "admin/admin_notice_view";
    }

    // 공지글쓰기 화면
    @GetMapping("/admin-notice-write")
    public String viewAdminNoticeWrite() {
        return "admin/admin_notice_write";
    }
}
