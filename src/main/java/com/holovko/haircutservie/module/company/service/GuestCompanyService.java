package com.holovko.haircutservie.module.company.service;

import com.holovko.haircutservie.module.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public final class GuestCompanyService  implements CompanyListable, CompanyReadable {
    private final CompanyRepository companyRepository;

    public GuestCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }
}
