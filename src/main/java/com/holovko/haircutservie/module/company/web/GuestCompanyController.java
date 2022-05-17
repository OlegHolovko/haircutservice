package com.holovko.haircutservie.module.company.web;

import com.holovko.haircutservie.module.company.service.CompanyService;
import com.holovko.haircutservie.module.company.web.dto.GuestCompanyDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/companies")
public class GuestCompanyController {
    private final CompanyService companyService;

    public GuestCompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("")
    public String list() {
        return "List of companies";
    }

    @GetMapping("/{companyId}")
    public String getById(@PathVariable Long companyId) {
        return "Company data";
    }

    @PostMapping(value = "", produces = "application/json")
    public String create(@RequestBody GuestCompanyDto companyDto) {
        return companyService.create(companyDto);
    }

    @PutMapping(value = "/{companyId}", produces = "application/json")
    public String update(@PathVariable Long companyId, @RequestBody GuestCompanyDto companyDto) {
        return "Company updated";
    }

    @DeleteMapping("/{companyId}")
    public String delete(@PathVariable Long companyId) {
        return "Company deleted";
    }
}


