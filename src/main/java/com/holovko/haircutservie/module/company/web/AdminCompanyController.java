package com.holovko.haircutservie.module.company.web;

import com.holovko.haircutservie.module.company.service.AdminCompanyService;
import com.holovko.haircutservie.module.company.web.dto.AdminCompanyDto;
import com.holovko.haircutservie.module.company.web.dto.GuestCompanyDto;
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

    @GetMapping("/{currentPage}/{pageSize}/{sortBy}/{direction}")
    public List<AdminCompanyDto> list(
            @PathVariable Integer currentPage,
            @PathVariable  Integer pageSize,
            @PathVariable  String sortBy,
            @PathVariable String direction
    ) {
        return adminCompanyService.list(adminCompanyService.getCompanyRepository(), currentPage, pageSize, sortBy, direction)
                .stream()
                .map(adminCompanyMapper::fromCompany)
                .toList();
    }

    @GetMapping("/{companyId}")
    public AdminCompanyDto getById(@PathVariable Long companyId) {
        return adminCompanyMapper.fromCompany(adminCompanyService.read(companyId));
    }
}


