package com.holovko.haircutservie.module.company.service.action;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.module.company.exception.CompanyNotFoundException;
import com.holovko.haircutservie.module.company.repository.CompanyRepository;

public interface CompanyReadable {
    default Company read(
            CompanyRepository companyRepository,
            Long companyId
    ) throws CompanyNotFoundException {
        return companyRepository.findById(companyId).orElseThrow(CompanyNotFoundException::new);
    }
}
