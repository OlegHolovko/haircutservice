package com.holovko.haircutservie.stuff.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {
    @GetMapping(value = "")
    public String list() {
        return "List of companies";
    }

    @GetMapping(value = "/{companyId}")
    public String getById(@PathVariable(value = "companyId") Long companyId) {
        return "Company data";
    }

    @PostMapping(value = "", produces = "application/json")
    public String create(@RequestBody CompanyDTO companyDTO) {
        return "Company crated";
    }

    @PutMapping(value = "/{companyId}", produces = "application/json")
    public String update(@PathVariable(value = "companyId") Long companyId, @RequestBody CompanyDTO companyDTO) {
        return "Company updated";
    }

    @DeleteMapping(value = "/{companyId}")
    public String delete(@PathVariable(value = "companyId") Long companyId) {
        return "Company deleted";
    }
}


