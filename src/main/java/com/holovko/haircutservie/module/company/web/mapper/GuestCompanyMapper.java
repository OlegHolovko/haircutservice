package com.holovko.haircutservie.module.company.web.mapper;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.module.company.web.dto.GuestCompanyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuestCompanyMapper {

    Company toCompany(GuestCompanyDto companyDto);
    GuestCompanyDto fromCompany(Company company);
}
