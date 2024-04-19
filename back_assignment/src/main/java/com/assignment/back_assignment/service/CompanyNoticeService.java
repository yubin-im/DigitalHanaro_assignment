package com.assignment.back_assignment.service;

import com.assignment.back_assignment.adminDto.UpdateNoticeReqDTO;
import com.assignment.back_assignment.adminDto.WriteNoticeReqDTO;
import com.assignment.back_assignment.dto.CompanyNoticeDTO;
import com.assignment.back_assignment.entity.CompanyNotice;
import com.assignment.back_assignment.repository.CompanyNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
            companyNoticeList = companyNoticeRepository.findByNoticeTitleContaining(searchText);
        } else if ("내용".equals(searchType)) {
            companyNoticeList = companyNoticeRepository.findByNoticeContentContaining(searchText);
        } else {
            companyNoticeList = Collections.emptyList();
        }

        return companyNoticeList.stream()
                .map(this::convertToCompanyNoticeDTO)
                .collect(Collectors.toList());
    }

    // 관리자 페이지- 공지사항 관리- 공지사항 검색 기능
    @Transactional
    public List<CompanyNoticeDTO> adminSearchNotices(String searchType, String searchText) {
        List<CompanyNotice> companyNoticeList;

        if("title".equals(searchType)) {
            companyNoticeList = companyNoticeRepository.findByNoticeTitleContaining(searchText);
        } else if ("content".equals(searchType)) {
            companyNoticeList = companyNoticeRepository.findByNoticeContentContaining(searchText);
        } else if ("id".equals(searchType)) {
            companyNoticeList = companyNoticeRepository.findByNoticeMemberIdContaining(searchText);
        } else {
            companyNoticeList = companyNoticeRepository.findByNoticeTitleOrNoticeContentOrNoticeMemberIdContaining(searchText);
        }

        return companyNoticeList.stream()
                .map(this::convertToCompanyNoticeDTO)
                .collect(Collectors.toList());
    }

    // 공지사항 정렬 기능
    @Transactional
    public List<CompanyNoticeDTO> sortNotices(String sortType, String sortOption) {
        List<CompanyNotice> companyNoticeList = null;

        if("noticeMemberId".equals(sortOption)) {
            if("ASC".equals(sortType)) {
                companyNoticeList = companyNoticeRepository.findAllByOrderByNoticeMemberIdAsc();
            } else {
                companyNoticeList = companyNoticeRepository.findAllByOrderByNoticeMemberIdDesc();
            }
        } else if ("noticeDate".equals(sortOption)) {
            if("ASC".equals(sortType)) {
                companyNoticeList = companyNoticeRepository.findAllByOrderByNoticeDateAsc();
            } else {
                companyNoticeList = companyNoticeRepository.findAllByOrderByNoticeDateDesc();
            }
        }

        // CompanyNotice Entity -> CompanyNotice DTO
        return companyNoticeList.stream()
                .map(this::convertToCompanyNoticeDTO)
                .collect(Collectors.toList());
    }

    // 공지사항 목록 행수 조절 기능
    @Transactional
    public Page<CompanyNotice> changeNoticeListSize(String pageSize) {
        if("page5".equals(pageSize)) {
            return companyNoticeRepository.findAll(PageRequest.of(0, 5));
        } else if ("page10".equals(pageSize)) {
            return companyNoticeRepository.findAll(PageRequest.of(0, 10));
        } else {
            return companyNoticeRepository.findAll(PageRequest.of(0, Integer.MAX_VALUE));
        }
    }

    // 공지사항 등록 기능
    @Transactional
    public CompanyNotice writeNotice(WriteNoticeReqDTO writeNoticeReqDTO) {
        CompanyNotice companyNotice = CompanyNotice.builder()
                .noticeTitle(writeNoticeReqDTO.getNoticeTitle())
                .noticeContent(writeNoticeReqDTO.getNoticeContent())
                .noticeMemberId("admin")
                .noticeDate(LocalDate.now())
                .build();
        companyNoticeRepository.save(companyNotice);

        return companyNotice;
    }

    // 공지사항 수정 기능
    @Transactional
    public CompanyNotice updateAdminNotice(UpdateNoticeReqDTO updateNoticeReqDTO) {
        Long noticeIdx = updateNoticeReqDTO.getNoticeIdx();
        String noticeContent = updateNoticeReqDTO.getNoticeContent();

        CompanyNotice companyNotice = companyNoticeRepository.findById(noticeIdx).orElse(null);
        companyNotice.updateNotice(noticeContent);
        companyNoticeRepository.save(companyNotice);

        return companyNotice;
    }
}
