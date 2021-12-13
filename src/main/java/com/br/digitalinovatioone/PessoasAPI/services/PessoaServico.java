package com.br.digitalinovatioone.PessoasAPI.services;

import com.br.digitalinovatioone.PessoasAPI.dto.request.PessoaDTO;
import com.br.digitalinovatioone.PessoasAPI.dto.response.ResponseMessage;
import com.br.digitalinovatioone.PessoasAPI.entities.Pessoa;
import com.br.digitalinovatioone.PessoasAPI.exceptions.PessoaNotFoundException;
import com.br.digitalinovatioone.PessoasAPI.mapper.PessoaMapper;
import com.br.digitalinovatioone.PessoasAPI.repositories.PessoaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaServico {
    private final PessoaRepositorio pessoaRepositorio;

    private final PessoaMapper pessoaMaper = PessoaMapper.INSTANCE;


    public ResponseMessage criaPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa_a_salvar = pessoaMaper.toModel(pessoaDTO);

        Pessoa pessoaSalva = pessoaRepositorio.save(pessoa_a_salvar);
        return getResponseMessage(pessoaSalva, "Pessoa salva com sucesso! id: ");
    }

    public List<PessoaDTO> listar() {
        List<Pessoa> pessoas = pessoaRepositorio.findAll();
        return pessoas.stream()
                .map(pessoaMaper::toDTO)
                .collect(Collectors.toList());

    }

    public PessoaDTO procuraPorId(long id) throws PessoaNotFoundException {
        Pessoa pessoa = verificaSeExiste(id);

        return pessoaMaper.toDTO(pessoa);
    }

    public void deletar(long id) throws PessoaNotFoundException {
        Pessoa pessoa = verificaSeExiste(id);
        pessoaRepositorio.delete(pessoa);
    }

    public ResponseMessage alteraPorId(long id, PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        verificaSeExiste(id);

        Pessoa pessoa_a_alterar = pessoaMaper.toModel(pessoaDTO);

        Pessoa pessoaAlterada = pessoaRepositorio.save(pessoa_a_alterar);
        return getResponseMessage(pessoaAlterada, "Pessoa alterada com sucesso! Id: ");
    }

    private ResponseMessage getResponseMessage(Pessoa pessoaSalva, String message) {
        return ResponseMessage
                .builder()
                .message(message + pessoaSalva.getId())
                .build();
    }

    private Pessoa verificaSeExiste(long id) throws PessoaNotFoundException {
        return pessoaRepositorio.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }
}
