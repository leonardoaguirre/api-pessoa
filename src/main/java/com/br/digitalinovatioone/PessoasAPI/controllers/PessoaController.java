package com.br.digitalinovatioone.PessoasAPI.controllers;

import com.br.digitalinovatioone.PessoasAPI.dto.response.ResponseMessage;
import com.br.digitalinovatioone.PessoasAPI.dto.request.PessoaDTO;
import com.br.digitalinovatioone.PessoasAPI.exceptions.PessoaNotFoundException;
import com.br.digitalinovatioone.PessoasAPI.services.PessoaServico;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {
    private final PessoaServico pessoaServico;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage criaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaServico.criaPessoa(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listarPessoas(){
        return pessoaServico.listar();
    }

    @GetMapping("/{id}")
    public PessoaDTO procuraPorId(@PathVariable long id) throws PessoaNotFoundException {
        return pessoaServico.procuraPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaPorId(@PathVariable long id) throws PessoaNotFoundException {
        pessoaServico.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseMessage alterarPorId(@PathVariable long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        return  pessoaServico.alteraPorId(id, pessoaDTO);
    }
}