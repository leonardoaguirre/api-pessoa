package com.br.digitalinovatioone.PessoasAPI.dto.request;

import com.br.digitalinovatioone.PessoasAPI.entities.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private long id;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String nome;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String sobrenome;

    @NotEmpty
    @Size(min = 11,max = 11)
    private String cpf;

    private String aniversario;

    @Valid
    @NotEmpty
    private List<Telefone> telefones;
}
