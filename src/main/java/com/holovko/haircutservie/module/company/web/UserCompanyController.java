package com.holovko.haircutservie.module.company.web;

import com.holovko.haircutservie.module.company.service.UserCompanyService;
import com.holovko.haircutservie.module.company.web.dto.UserCompanyDto;
import com.holovko.haircutservie.module.company.web.mapper.UserCompanyMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user/companies")
public class UserCompanyController {
    private final UserCompanyService userCompanyService;
    private final UserCompanyMapper userCompanyMapper;

    public UserCompanyController(UserCompanyService userCompanyService, UserCompanyMapper userCompanyMapper) {
        this.userCompanyService = userCompanyService;
        this.userCompanyMapper = userCompanyMapper;
    }

    @GetMapping("")
    public List<UserCompanyDto> list() {
        return userCompanyService.list()
                .stream()
                .map(userCompanyMapper::fromCompany)
                .toList();
    }

    @GetMapping("/{companyId}")
    public UserCompanyDto getById(@PathVariable Long companyId) {
        return userCompanyMapper.fromCompany(userCompanyService.read(companyId));
    }
}


