package com.holovko.haircutservie.module.company.web.mapper;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.module.company.web.dto.GuestCompanyRequestDto;
import com.holovko.haircutservie.module.company.web.dto.GuestCompanyResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuestCompanyMapper {

    Company toCompany(GuestCompanyRequestDto companyDto);
    GuestCompanyResponseDto fromCompany(Company company);
}
