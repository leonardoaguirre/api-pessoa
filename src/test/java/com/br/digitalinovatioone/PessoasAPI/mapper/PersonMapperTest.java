package com.br.digitalinovatioone.PessoasAPI.mapper;

import com.br.digitalinovatioone.PessoasAPI.dto.request.PessoaDTO;
import com.br.digitalinovatioone.PessoasAPI.dto.request.TelefoneDTO;
import com.br.digitalinovatioone.PessoasAPI.entities.Pessoa;
import com.br.digitalinovatioone.PessoasAPI.entities.Telefone;
import com.br.digitalinovatioone.PessoasAPI.utils.PessoaUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PessoaMapper personMapper;

    @Test
    void testPessoaDTORetornaEntidadePessoa() {
        PessoaDTO pessoaDTO = PessoaUtils.criaFakeDTO();
        Pessoa pessoa = personMapper.toModel(pessoaDTO);

        assertEquals(pessoaDTO.getNome(), pessoa.getNome());
        assertEquals(pessoaDTO.getSobrenome(), pessoa.getSobrenome());
        assertEquals(pessoaDTO.getCpf(), pessoa.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefoneDTO.getTipoTelefone(), telefone.getTipoTelefone());
        assertEquals(telefoneDTO.getNumero(), telefone.getNumero());
        assertEquals(telefoneDTO.getDdd(), telefone.getDdd());
    }

    @Test
    void testEntidadePessoaRetornaPessoaDTO() {
        Pessoa pessoa = PessoaUtils.criaFakeEntity();
        PessoaDTO pessoaDTO = personMapper.toDTO(pessoa);

        assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        assertEquals(pessoa.getSobrenome(), pessoaDTO.getSobrenome());
        assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefone.getTipoTelefone(), telefoneDTO.getTipoTelefone());
        assertEquals(telefone.getNumero(), telefoneDTO.getNumero());
        assertEquals(telefone.getDdd(), telefoneDTO.getDdd());
    }
}
