package com.assignment.back_assignment.controller;

import com.assignment.back_assignment.dto.FindIdReqDTO;
import com.assignment.back_assignment.dto.FindPwReqDTO;
import com.assignment.back_assignment.dto.JoinReqDTO;
import com.assignment.back_assignment.entity.CompanyMember;
import com.assignment.back_assignment.service.CompanyMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainApiController {
    final private CompanyMemberService companyMemberService;

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

}
