package com.holovko.haircutservie.module.company.web;

import com.holovko.haircutservie.module.company.service.AdminCompanyService;
import com.holovko.haircutservie.module.company.web.dto.AdminCompanyDto;
import com.holovko.haircutservie.module.company.web.mapper.AdminCompanyMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/companies")
public class AdminCompanyController {
    private final AdminCompanyService adminCompanyService;
    private final AdminCompanyMapper adminCompanyMapper;

    public AdminCompanyController(AdminCompanyService adminCompanyService, AdminCompanyMapper adminCompanyMapper) {
        this.adminCompanyService = adminCompanyService;
        this.adminCompanyMapper = adminCompanyMapper;
    }

    @GetMapping("")
    public List<AdminCompanyDto> list() {
        return adminCompanyService.list(adminCompanyService.getCompanyRepository())
                .stream()
                .map(adminCompanyMapper::fromCompany)
                .toList();
    }

    @GetMapping("/{companyId}")
    public AdminCompanyDto getById(@PathVariable Long companyId) {
        return adminCompanyMapper.fromCompany(adminCompanyService.read(companyId));
    }
}


