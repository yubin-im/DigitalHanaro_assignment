package com.assignment.back_assignment.service;

import com.assignment.back_assignment.dto.CompanyNoticeDTO;
import com.assignment.back_assignment.entity.CompanyNotice;
import com.assignment.back_assignment.repository.CompanyNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyNoticeService {
    final private CompanyNoticeRepository companyNoticeRepository;

    // 공지사항 전체 조회
    @Transactional
    public List<CompanyNoticeDTO> findAll() {
        List<CompanyNotice> companyNoticeList = companyNoticeRepository.findAll();

        // CompanyNotice Entity -> CompanyNotice DTO
        return companyNoticeList.stream()
                .map(this::convertToCompanyNoticeDTO)
                .collect(Collectors.toList());
    }

    // 공지사항 상세 조회
    @Transactional
    public CompanyNotice findById(Long noticeIdx) {
        CompanyNotice companyNotice = companyNoticeRepository.findById(noticeIdx).orElse(null);
        return companyNotice;
    }

    // CompanyNotice Entity -> CompanyNotice DTO
    private CompanyNoticeDTO convertToCompanyNoticeDTO(CompanyNotice companyNotice) {
        return CompanyNoticeDTO.builder()
                .noticeIdx(companyNotice.getNoticeIdx())
                .noticeTitle(companyNotice.getNoticeTitle())
                .noticeContent(companyNotice.getNoticeContent())
                .noticeMemberId(companyNotice.getNoticeMemberId())
                .noticeDate(companyNotice.getNoticeDate())
                .build();
    }

    // 공지사항 검색 기능
    @Transactional
    public List<CompanyNoticeDTO> searchNotices(String searchType, String searchText) {
        List<CompanyNotice> companyNoticeList;

        if ("제목".equals(searchType)) {
            companyNoticeList =  companyNoticeRepository.findByNoticeTitleContaining(searchText);
        } else if ("내용".equals(searchType)) {
            companyNoticeList = companyNoticeRepository.findByNoticeContentContaining(searchText);
        } else {
            companyNoticeList = Collections.emptyList();
        }

        return companyNoticeList.stream()
                .map(this::convertToCompanyNoticeDTO)
                .collect(Collectors.toList());
    }
}
