package com.holovko.haircutservie.module.company.service.action;

import com.holovko.haircutservie.domain.Company;

public interface CompanyReadable {
    default Company read(Long companyId){

        return null;
    }
}
