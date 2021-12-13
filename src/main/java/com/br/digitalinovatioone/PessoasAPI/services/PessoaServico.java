package com.br.digitalinovatioone.PessoasAPI.services;

import com.br.digitalinovatioone.PessoasAPI.dto.ResponseMessage;
import com.br.digitalinovatioone.PessoasAPI.dto.request.PessoaDTO;
import com.br.digitalinovatioone.PessoasAPI.entities.Pessoa;
import com.br.digitalinovatioone.PessoasAPI.exceptions.PessoaNotFoundException;
import com.br.digitalinovatioone.PessoasAPI.mapper.PessoaMapper;
import com.br.digitalinovatioone.PessoasAPI.repositories.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaServico {
    private final PessoaRepositorio pessoaRepositorio;

    private final PessoaMapper pessoaMaper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaServico(PessoaRepositorio pessoaRepositorio) {
        this.pessoaRepositorio = pessoaRepositorio;
    }
    public ResponseMessage criaPessoa( PessoaDTO pessoaDTO) {
        Pessoa pessoa_a_salvar= pessoaMaper.toModel(pessoaDTO);

        Pessoa pessoaSalva = pessoaRepositorio.save(pessoa_a_salvar);
        return ResponseMessage
                .builder()
                .message("Pessoa criada com sucesso! ID: " + pessoaSalva.getId())
                .build();
    }

    public List<PessoaDTO> listar() {
        List<Pessoa> pessoas = pessoaRepositorio.findAll();
        return pessoas.stream()
                .map(pessoaMaper::toDTO)
                .collect(Collectors.toList());

    }
    private Pessoa verificaSeExiste(long id) throws PessoaNotFoundException {
        return pessoaRepositorio.findById(id)
                .orElseThrow(()-> new PessoaNotFoundException(id));
    }

    public PessoaDTO procuraPorId(long id) throws PessoaNotFoundException {
        Pessoa pessoa = verificaSeExiste(id);

        return pessoaMaper.toDTO(pessoa);
    }

    public void deletar(long id) throws PessoaNotFoundException {
        Pessoa pessoa = verificaSeExiste(id);
        pessoaRepositorio.delete(pessoa);
    }

}
