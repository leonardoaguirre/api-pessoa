package com.br.digitalinovatioone.PessoasAPI.dto.request;

import com.br.digitalinovatioone.PessoasAPI.enums.TipoTelefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {
    private long id;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

    @NotEmpty
    @Size(min = 2, max = 2)
    private int ddd;

    @NotEmpty
    @Size(min = 8, max = 9)
    private String numero;
}
