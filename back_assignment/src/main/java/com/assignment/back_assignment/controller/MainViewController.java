package com.assignment.back_assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainViewController {
    // 메인 화면
    @GetMapping("/")
    public String viewMain() {
        return "index";
    }

    // 로그인 화면
    @GetMapping("/member/login")
    public String viewLogin(){
        return "member/login";
    }

    // 회원가입 화면
    @GetMapping("/member/join")
    public String viewJoin(){
        return "member/join2";
    }

    // 아이디찾기 화면
    @GetMapping("/idFind")
    public String viewFindId(){
        return "member/idFind";
    }

    // 비밀번호찾기 화면
    @GetMapping("/passwordFind")
    public String viewFindPwd(){
        return "member/passwordFind";
    }

    // 공지사항 화면
    @GetMapping("/community/community01")
    public String viewAnnounce(){
        return "community/community01";
    }

    // 공지사항- 상세 화면
    @GetMapping("/community/community01_1")
    public String viewAnnounceDetail(){
        return "community/community01_1";
    }

    // 1:1문의 화면
    @GetMapping("/customer/customer01")
    public String viewInquiry() {
        return "customer/customer01";
    }

    // 묻고답하기 화면
    @GetMapping("/customer/customer02")
    public String viewQnA(){
        return "customer/customer02";
    }

    // 묻고답하기- 상세 비밀번호확인 화면
    @GetMapping("/customer/customer02_3")
    public String viewQnADetailPwd(){
        return "customer/customer02_3";
    }

    // 묻고답하기- 상세 화면
    @GetMapping("/customer/customer02_4")
    public String viewQnADetail(){
        return "customer/customer02_4";
    }
}
