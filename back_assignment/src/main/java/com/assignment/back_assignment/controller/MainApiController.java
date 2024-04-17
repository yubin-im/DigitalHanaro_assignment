package com.assignment.back_assignment.controller;

import com.assignment.back_assignment.entity.CompanyFaq;
import com.assignment.back_assignment.service.CompanyFaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainApiController {
    final private CompanyFaqService companyFaqService;

    // DB 연결 확인 완료
    @PostMapping("/")
    @ResponseBody
    public List<CompanyFaq> companyFaqList() {
        List<CompanyFaq> companyFaqList = companyFaqService.findAll();
        return companyFaqList;
    }
}
