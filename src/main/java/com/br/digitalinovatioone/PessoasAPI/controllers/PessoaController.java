package com.br.digitalinovatioone.PessoasAPI.controllers;

import com.br.digitalinovatioone.PessoasAPI.dto.ResponseMessage;
import com.br.digitalinovatioone.PessoasAPI.entities.Pessoa;
import com.br.digitalinovatioone.PessoasAPI.repositories.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {
    private final PessoaRepositorio pessoaReporitorio;

    @Autowired
    public PessoaController(PessoaRepositorio pessoaReporitorio) {
        this.pessoaReporitorio = pessoaReporitorio;
    }

    @GetMapping
    public String getPessoa() {
        return "Olá esta é minha api";
    }

    @PostMapping
    public ResponseMessage criaPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaSaved = pessoaReporitorio.save(pessoa);
        return ResponseMessage
                .builder()
                .message("Pessoa criada com sucesso! ID: " + pessoaSaved.getId())
                .build();
    }
}