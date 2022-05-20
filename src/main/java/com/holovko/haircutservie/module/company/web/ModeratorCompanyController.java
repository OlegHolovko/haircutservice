package com.holovko.haircutservie.module.company.web;

import com.holovko.haircutservie.module.company.service.ModeratorCompanyService;
import com.holovko.haircutservie.module.company.web.dto.ModeratorCompanyDto;
import com.holovko.haircutservie.module.company.web.mapper.ModeratorCompanyMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/moderator/companies")
public class ModeratorCompanyController {
    private final ModeratorCompanyService moderatorCompanyService;
    private final ModeratorCompanyMapper moderatorCompanyMapper;

    public ModeratorCompanyController(ModeratorCompanyService moderatorCompanyService, ModeratorCompanyMapper moderatorCompanyMapper) {
        this.moderatorCompanyService = moderatorCompanyService;
        this.moderatorCompanyMapper = moderatorCompanyMapper;
    }

    @GetMapping("")
    public List<ModeratorCompanyDto> list() {
        return moderatorCompanyService.list()
                .stream()
                .map(moderatorCompanyMapper::fromCompany)
                .toList();
    }

    @GetMapping("/{companyId}")
    public ModeratorCompanyDto getById(@PathVariable Long companyId) {
        return moderatorCompanyMapper.fromCompany(moderatorCompanyService.read(companyId));
    }
}


