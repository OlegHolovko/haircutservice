package com.holovko.haircutservie.module.company.web.mapper;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.module.company.web.dto.CompanyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toCompany(CompanyDTO companyDto);
    CompanyDTO fromCompany(Company company);
}
