package com.holovko.haircutservie.module.company.web.mapper;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.module.company.web.dto.UserCompanyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCompanyMapper {

    Company toCompany(UserCompanyDto companyDto);
    UserCompanyDto fromCompany(Company company);
}
