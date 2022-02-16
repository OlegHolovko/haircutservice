package com.holovko.haircutservie.stuff.web;

import javax.validation.constraints.NotNull;

public class CompanyDTO {
    private Long id;
    @NotNull
    private String name;

    public CompanyDTO() {
    }

    public CompanyDTO(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
