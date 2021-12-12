package com.br.digitalinovatioone.PessoasAPI.services;

import com.br.digitalinovatioone.PessoasAPI.dto.ResponseMessage;
import com.br.digitalinovatioone.PessoasAPI.entities.Pessoa;
import com.br.digitalinovatioone.PessoasAPI.repositories.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaServico {
    private final PessoaRepositorio pessoaRepositorio;

    @Autowired
    public PessoaServico(PessoaRepositorio pessoaRepositorio) {
        this.pessoaRepositorio = pessoaRepositorio;
    }
    public ResponseMessage criaPessoa( Pessoa pessoa) {
        Pessoa pessoaSaved = pessoaRepositorio.save(pessoa);
        return ResponseMessage
                .builder()
                .message("Pessoa criada com sucesso! ID: " + pessoaSaved.getId())
                .build();
    }
}
