package com.holovko.haircutservie.module.company.web;

import com.holovko.haircutservie.module.company.repository.CompanyRepository;
import com.holovko.haircutservie.module.company.service.GuestCompanyService;
import com.holovko.haircutservie.module.company.web.dto.GuestCompanyDto;
import com.holovko.haircutservie.module.company.web.mapper.GuestCompanyMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companies")
public class GuestCompanyController {
    private final GuestCompanyService guestCompanyService;
    private final GuestCompanyMapper guestCompanyMapper;

    public GuestCompanyController(GuestCompanyService guestCompanyService, GuestCompanyMapper guestCompanyMapper) {
        this.guestCompanyService = guestCompanyService;
        this.guestCompanyMapper = guestCompanyMapper;
    }

    @GetMapping("")
    public List<GuestCompanyDto> list() {
        return guestCompanyService.list(guestCompanyService.getCompanyRepository())
                .stream()
                .map(guestCompanyMapper::fromCompany)
                .toList();
    }

    @GetMapping("/{companyId}")
    public GuestCompanyDto getById(@PathVariable Long companyId) {
        return guestCompanyMapper.fromCompany(guestCompanyService.read(companyId));
    }

}


