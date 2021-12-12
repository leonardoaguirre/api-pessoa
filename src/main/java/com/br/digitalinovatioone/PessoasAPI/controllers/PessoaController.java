package com.br.digitalinovatioone.PessoasAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    @GetMapping
    public String getPessoa() {
        return "Olá esta é minha API";
    }
}