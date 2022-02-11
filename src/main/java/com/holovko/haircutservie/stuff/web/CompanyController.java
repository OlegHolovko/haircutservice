package com.holovko.haircutservie.stuff.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {
    @GetMapping(value = "")
    public String list() {
        return "List of companies";
    }
}
