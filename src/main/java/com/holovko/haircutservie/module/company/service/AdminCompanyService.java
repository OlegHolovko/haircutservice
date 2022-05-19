package com.holovko.haircutservie.module.company.service;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.module.company.web.dto.GuestCompanyDto;
import com.holovko.haircutservie.module.company.web.mapper.GuestCompanyMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminCompanyService {
    private final GuestCompanyMapper companyMapper;

    public AdminCompanyService(GuestCompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }


    public String create(GuestCompanyDto companyDto) {
        Company company = companyMapper.toCompany(companyDto);
        return company.getName();
    }
}