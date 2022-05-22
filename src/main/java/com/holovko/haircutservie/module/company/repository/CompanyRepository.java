package com.holovko.haircutservie.module.company.repository;

import com.holovko.haircutservie.domain.Company;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository  extends CrudRepository<Company, Long> {
    List<Company> findAll(Sort sort);
}
