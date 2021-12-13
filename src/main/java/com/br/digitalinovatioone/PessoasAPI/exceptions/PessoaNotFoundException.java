package com.br.digitalinovatioone.PessoasAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNotFoundException extends Exception {
    public PessoaNotFoundException(long id) {
        super("Pessoa não encontrada com id: "+id);
    }
}
