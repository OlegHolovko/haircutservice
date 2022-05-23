package com.holovko.haircutservie.module.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;

    public CompanyNotFoundException(){
        super("Company not found!");
    }
}
