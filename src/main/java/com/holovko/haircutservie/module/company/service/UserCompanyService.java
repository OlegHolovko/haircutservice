package com.holovko.haircutservie.module.company.service;

import com.holovko.haircutservie.module.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public final class UserCompanyService implements CompanyListable, CompanyReadable, CompanySaveable {
    private final CompanyRepository companyRepository;

    public UserCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }
}
