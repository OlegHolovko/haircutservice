package com.holovko.haircutservie.module.company.service.action;

import com.holovko.haircutservie.domain.Company;

import java.util.Arrays;
import java.util.List;

public interface CompanyListable {
    default List<Company> list(){
        Company c1 = new Company();
        c1.setId(1L);
        c1.setName("First");
        c1.setDescription("Description1");
        Company c2 = new Company();
        c2.setId(2L);
        c2.setName("Second");
        c2.setDescription("Description2");
        List<Company> list = Arrays.asList(c1, c2);
        return list;
    }
}
