package com.br.digitalinovatioone.PessoasAPI.utils;

import com.br.digitalinovatioone.PessoasAPI.dto.request.PessoaDTO;
import com.br.digitalinovatioone.PessoasAPI.entities.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {
    private static final String NOME = "Leonardo";
    private static final String SOBRENOME = "Vinicius";
    private static final String CPF = "12345678945";
    private static final Long ID = 1L;
    private static final LocalDate ANIVERSARIO = LocalDate.of(2000, 6, 4);

    public static PessoaDTO criaFakeDTO(){
        return PessoaDTO.builder()
                .cpf(CPF)
                .id(ID)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .aniversario("04-06-2000")
                .telefones(Collections.singletonList(TelefoneUtils.criaFakeDTO()))
                .build();
    }
    public static Pessoa criaFakeEntity(){
        return Pessoa.builder()
                .cpf(CPF)
                .id(ID)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .aniversario(ANIVERSARIO)
                .telefones(Collections.singletonList(TelefoneUtils.criaFakeEntity()))
                .build();
    }
}
