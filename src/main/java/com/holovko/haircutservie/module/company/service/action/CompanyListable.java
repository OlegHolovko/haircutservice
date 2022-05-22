package com.holovko.haircutservie.module.company.service.action;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.module.company.repository.CompanyRepository;
import java.util.List;

import static com.holovko.haircutservie.domain.BaseEntity.SORT_BY_CREATED_AT_DESC;

public interface CompanyListable {
    default List<Company> list(CompanyRepository companyRepository){
        return companyRepository.findAll(SORT_BY_CREATED_AT_DESC);
    }
}
