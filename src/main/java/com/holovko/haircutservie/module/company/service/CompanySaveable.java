package com.holovko.haircutservie.module.company.service;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.domain.type.BooleanEnum;
import com.holovko.haircutservie.domain.type.CompanyType;
import com.holovko.haircutservie.module.company.repository.CompanyRepository;

public sealed interface CompanySaveable
        permits AdminCompanyService, GuestCompanyService, ModeratorCompanyService, UserCompanyService{
    default Company save(CompanyRepository companyRepository,
                         Long companyId,
                         Company companyRequest) throws NoSuchFieldException {
        Company company = new Company();
        if(companyId > 0) {
            company = companyRepository.findById(companyId).orElseThrow();
        }
        if(!companyRequest.getName().isBlank()) {
            company.setName(companyRequest.getName());
        }
        if(!companyRequest.getEnabled().equals(BooleanEnum.UNKNOWN)) {
            company.setEnabled(companyRequest.getEnabled());
        }
        if(!companyRequest.getFilepath().isBlank() && !companyRequest.getLogo().isBlank()){
            company.setFilepath(companyRequest.getFilepath());
            company.setLogo(companyRequest.getLogo());
        }
        if(!companyRequest.getDescription().isBlank()) {
            company.setDescription(companyRequest.getDescription());
        }
        if(!companyRequest.getContacts().isBlank()) {
            company.setContacts(companyRequest.getContacts());
        }
        if(!companyRequest.getType().equals(CompanyType.UNKNOWN)) {
            company.setType(companyRequest.getType());
        }

        return company;
    }
}
