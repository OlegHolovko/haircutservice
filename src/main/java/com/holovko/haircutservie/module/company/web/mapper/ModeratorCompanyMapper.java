package com.holovko.haircutservie.module.company.web.mapper;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.module.company.web.dto.ModeratorCompanyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModeratorCompanyMapper {

    Company toCompany(ModeratorCompanyDto companyDto);
    ModeratorCompanyDto fromCompany(Company company);
}
