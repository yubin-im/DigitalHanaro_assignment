package com.assignment.back_assignment.service;

import com.assignment.back_assignment.dto.CompanyQnaDTO;
import com.assignment.back_assignment.entity.CompanyQna;
import com.assignment.back_assignment.repository.CompanyQnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyQnaService {
    private final CompanyQnaRepository companyQnaRepository;

    // CompanyQna Entity -> CompanyQna DTO
    private CompanyQnaDTO convertToCompanyQnaDTO(CompanyQna companyQna) {
        return CompanyQnaDTO.builder()
                .qnaIdx(companyQna.getQnaIdx())
                .qnaName(companyQna.getQnaName())
                .qnaPw(companyQna.getQnaPw())
                .qnaTitle(companyQna.getQnaTitle())
                .qnaContent(companyQna.getQnaContent())
                .qnaDate(companyQna.getQnaDate())
                .build();
    }

    // 묻고답하기 전체 조회
    @Transactional
    public List<CompanyQnaDTO> findAll() {
        List<CompanyQna> companyQnaList = companyQnaRepository.findAll();

        // CompanyQna Entity -> CompanyQna DTO
        return companyQnaList.stream()
                .map(this::convertToCompanyQnaDTO)
                .collect(Collectors.toList());
    }

    // 묻고답하기 상세 조회
    @Transactional
    public CompanyQnaDTO findById(Long qnaIdx) {
        CompanyQna companyQna = companyQnaRepository.findById(qnaIdx).orElse(null);
        CompanyQnaDTO companyQnaDTO = convertToCompanyQnaDTO(companyQna);

        return companyQnaDTO;
    }

    // 묻고답하기 상세- 비밀번호 확인
    @Transactional
    public boolean CheckQnaPw(Long qnaIdx, String qnaPw) {
        CompanyQna companyQna = companyQnaRepository.findById(qnaIdx).orElse(null);

        if(qnaPw.equals(companyQna.getQnaPw())) {
            return true;
        } else {
            return false;
        }
    }

    // 묻고답하기 검색 기능
    @Transactional
    public List<CompanyQnaDTO> searchQnas(String searchType, String seachText) {
        List<CompanyQna> companyQnaList;

        if("제목".equals(searchType)) {
            companyQnaList = companyQnaRepository.findByQnaTitleContaining(seachText);
        } else if ("내용".equals(searchType)) {
            companyQnaList = companyQnaRepository.findByQnaContentContaining(seachText);
        } else if ("작성자".equals(searchType)) {
            companyQnaList = companyQnaRepository.findByQnaNameContaining(seachText);
        } else {
            companyQnaList = Collections.emptyList();
        }

        // CompanyQna Entity -> CompanyQna DTO
        return companyQnaList.stream()
                .map(this::convertToCompanyQnaDTO)
                .collect(Collectors.toList());
    }

}
