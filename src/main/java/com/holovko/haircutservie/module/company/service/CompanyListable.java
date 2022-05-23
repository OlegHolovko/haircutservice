package com.holovko.haircutservie.module.company.service;

import com.holovko.haircutservie.domain.Company;
import com.holovko.haircutservie.module.company.repository.CompanyRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public sealed interface CompanyListable
        permits AdminCompanyService, GuestCompanyService, ModeratorCompanyService, UserCompanyService{

    default List<Company> list(
            CompanyRepository companyRepository,
            Integer pageNo,
            Integer pageSize,
            String sortBy,
            String direction
    )
    {
        Sort sort = Sort.by("created_id").descending();

        if(StringUtils.equals(direction,"asc")) {
            sort = Sort.by(sortBy).ascending();
        } else if(StringUtils.equals(direction,"desc")) {
            sort = Sort.by(sortBy).descending();
        }

        Pageable paging = PageRequest.of(pageNo, pageSize, sort);
        Page<Company> pagedResult = companyRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
