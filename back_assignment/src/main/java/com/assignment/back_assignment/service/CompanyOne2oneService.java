package com.assignment.back_assignment.service;

import com.assignment.back_assignment.dto.WriteOne2oneReqDTO;
import com.assignment.back_assignment.entity.CompanyOne2one;
import com.assignment.back_assignment.repository.CompanyOne2oneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CompanyOne2oneService {
    final private CompanyOne2oneRepository companyOne2oneRepository;

    // 1대1 문의 작성 기능
    @Transactional
    public CompanyOne2one writeOne2one(WriteOne2oneReqDTO writeOne2oneReqDTO) {
        CompanyOne2one companyOne2one = CompanyOne2one.builder()
                .one2oneName(writeOne2oneReqDTO.getOne2oneName())
                .one2onePhone(writeOne2oneReqDTO.getOne2onePhone())
                .one2oneEmail(writeOne2oneReqDTO.getOne2oneEmail())
                .one2oneAddress(writeOne2oneReqDTO.getOne2oneAddress())
                .one2oneTitle(writeOne2oneReqDTO.getOne2oneTitle())
                .one2oneContent(writeOne2oneReqDTO.getOne2oneContent())
                .one2oneDate(LocalDate.now())
                .build();
        companyOne2oneRepository.save(companyOne2one);
        return companyOne2one;
    }
}
