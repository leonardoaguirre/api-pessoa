package com.br.digitalinovatioone.PessoasAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {
    CASA("Casa"),
    CELULAR("Celular"),
    COMERCIAL("Comercial");
    private final String descricao;
}
