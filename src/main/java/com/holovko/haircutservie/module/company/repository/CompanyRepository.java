package com.holovko.haircutservie.module.company.repository;

import com.holovko.haircutservie.domain.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository  extends CrudRepository<Company, Long> {
}
