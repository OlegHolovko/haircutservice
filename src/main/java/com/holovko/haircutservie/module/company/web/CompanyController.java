package com.holovko.haircutservie.module.company.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {
    @GetMapping("")
    public String list() {
        return "List of companies";
    }

    @GetMapping("/{companyId}")
    public String getById(@PathVariable Long companyId) {
        return "Company data";
    }

    @PostMapping(value = "", produces = "application/json")
    public String create(@RequestBody CompanyDTO companyDTO) {
        return "Company crated";
    }

    @PutMapping(value = "/{companyId}", produces = "application/json")
    public String update(@PathVariable Long companyId, @RequestBody CompanyDTO companyDTO) {
        return "Company updated";
    }

    @DeleteMapping("/{companyId}")
    public String delete(@PathVariable Long companyId) {
        return "Company deleted";
    }
}


