package com.assignment.back_assignment.service;

import com.assignment.back_assignment.entity.CompanyFaq;
import com.assignment.back_assignment.repository.CompanyFaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyFaqService {
    final private CompanyFaqRepository companyFaqRepository;

    @Transactional
    public List<CompanyFaq> findAll() {
        List<CompanyFaq> companyFaqList = companyFaqRepository.findAll();
        return companyFaqList;
    }
}
