package com.br.digitalinovatioone.PessoasAPI.controllers;

import com.br.digitalinovatioone.PessoasAPI.dto.ResponseMessage;
import com.br.digitalinovatioone.PessoasAPI.dto.request.PessoaDTO;
import com.br.digitalinovatioone.PessoasAPI.entities.Pessoa;
import com.br.digitalinovatioone.PessoasAPI.services.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {
    private final PessoaServico pessoaServico;

    @Autowired
    public PessoaController(PessoaServico pessoaServico) {
        this.pessoaServico = pessoaServico;
    }

    @GetMapping
    public String getPessoa() {
        return "Olá esta é minha api";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage criaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaServico.criaPessoa(pessoaDTO);
    }
}