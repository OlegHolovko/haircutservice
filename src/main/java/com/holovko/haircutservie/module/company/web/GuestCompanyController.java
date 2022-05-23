package com.holovko.haircutservie.module.company.web;

import com.holovko.haircutservie.module.company.exception.CompanyNotFoundException;
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

    @GetMapping("/{currentPage}/{pageSize}/{sortBy}/{direction}")
    public List<GuestCompanyDto> list(
            @PathVariable Integer currentPage,
            @PathVariable Integer pageSize,
            @PathVariable String sortBy,
            @PathVariable String direction
    ) {
        return guestCompanyService.list(
                    guestCompanyService.getCompanyRepository(),
                    currentPage,
                    pageSize,
                    sortBy,
                    direction
                )
                .stream()
                .map(guestCompanyMapper::fromCompany)
                .toList();
    }

    @GetMapping("/{companyId}")
    public GuestCompanyDto getById(@PathVariable Long companyId) throws CompanyNotFoundException {
        return guestCompanyMapper.fromCompany(
                guestCompanyService.read(
                        guestCompanyService.getCompanyRepository(),
                        companyId
                )
        );
    }

}


