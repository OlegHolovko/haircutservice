package com.holovko.haircutservie.module.company.service;

import com.holovko.haircutservie.module.company.repository.CompanyRepository;
import com.holovko.haircutservie.module.company.service.action.CompanyListable;
import com.holovko.haircutservie.module.company.service.action.CompanyReadable;

import org.springframework.stereotype.Service;

@Service
public class ModeratorCompanyService implements CompanyListable, CompanyReadable {
    private final CompanyRepository companyRepository;

    public ModeratorCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }
}
