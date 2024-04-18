package com.assignment.back_assignment.service;

import com.assignment.back_assignment.entity.CompanyNotice;
import com.assignment.back_assignment.repository.CompanyNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyNoticeService {
    final private CompanyNoticeRepository companyNoticeRepository;

    // 공지사항 전체 조회
    @Transactional
    public List<CompanyNotice> findAll() {
        List<CompanyNotice> companyNoticeList = companyNoticeRepository.findAll();
        return companyNoticeList;
    }

    // 공자사항 상세 조회
    @Transactional
    public CompanyNotice findById(Long noticeIdx) {
        CompanyNotice companyNotice = companyNoticeRepository.findById(noticeIdx).orElse(null);
        return companyNotice;
    }
}
