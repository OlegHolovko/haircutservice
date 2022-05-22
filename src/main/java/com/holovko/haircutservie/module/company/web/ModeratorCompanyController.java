package com.holovko.haircutservie.module.company.web;

import com.holovko.haircutservie.module.company.service.ModeratorCompanyService;
import com.holovko.haircutservie.module.company.web.dto.GuestCompanyDto;
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

    @GetMapping("/{currentPage}/{pageSize}/{sortBy}/{direction}")
    public List<ModeratorCompanyDto> list(
            @PathVariable Integer currentPage,
            @PathVariable  Integer pageSize,
            @PathVariable  String sortBy,
            @PathVariable String direction
    ) {
        return moderatorCompanyService.list(moderatorCompanyService.getCompanyRepository(), currentPage, pageSize, sortBy, direction)
                .stream()
                .map(moderatorCompanyMapper::fromCompany)
                .toList();
    }

    @GetMapping("/{companyId}")
    public ModeratorCompanyDto getById(@PathVariable Long companyId) {
        return moderatorCompanyMapper.fromCompany(moderatorCompanyService.read(companyId));
    }
}


