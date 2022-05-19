package com.holovko.haircutservie.module.company.web.mapper;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.module.company.web.dto.AdminCompanyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminCompanyMapper {

    Company toCompany(AdminCompanyDto companyDto);
    AdminCompanyDto fromCompany(Company company);
}
