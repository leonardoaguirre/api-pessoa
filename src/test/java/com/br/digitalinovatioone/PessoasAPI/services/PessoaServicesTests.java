package com.br.digitalinovatioone.PessoasAPI.services;

import com.br.digitalinovatioone.PessoasAPI.dto.request.PessoaDTO;
import com.br.digitalinovatioone.PessoasAPI.dto.response.ResponseMessage;
import com.br.digitalinovatioone.PessoasAPI.entities.Pessoa;
import com.br.digitalinovatioone.PessoasAPI.repositories.PessoaRepositorio;
import com.br.digitalinovatioone.PessoasAPI.utils.PessoaUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PessoaServicesTests {
    @Mock
    private PessoaRepositorio pessoaRepositorio;

    @InjectMocks
    private PessoaServico pessoaServico;

    @Test
    void testSalvarPessoaDTO(){
        PessoaDTO pessoaDTO = PessoaUtils.criaFakeDTO();
        Pessoa pessoaSalvaEsperada = PessoaUtils.criaFakeEntity();

        Mockito.when(pessoaRepositorio.save(any(Pessoa.class)))
                .thenReturn(pessoaSalvaEsperada);

        ResponseMessage mensagemEsperada = criarMensagemEsperada(pessoaSalvaEsperada.getId());

        ResponseMessage responseMessage = pessoaServico.criaPessoa(pessoaDTO);

        Assertions.assertEquals(mensagemEsperada,responseMessage);
    }

    private ResponseMessage criarMensagemEsperada(Long id) {
        return ResponseMessage
                .builder()
                .message("Pessoa salva com sucesso! id: " + id)
                .build();
    }
}
