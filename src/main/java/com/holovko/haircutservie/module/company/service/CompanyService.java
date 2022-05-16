package com.holovko.haircutservie.module.company.service;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.module.company.web.dto.CompanyDTO;
import com.holovko.haircutservie.module.company.web.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }


    public String create(CompanyDTO companyDTO) {
        Company company = companyMapper.toCompany(companyDTO);
        return company.getName();
    }
}
