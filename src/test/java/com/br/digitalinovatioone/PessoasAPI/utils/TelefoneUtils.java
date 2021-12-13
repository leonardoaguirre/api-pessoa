package com.br.digitalinovatioone.PessoasAPI.utils;

import com.br.digitalinovatioone.PessoasAPI.dto.request.TelefoneDTO;
import com.br.digitalinovatioone.PessoasAPI.entities.Telefone;
import com.br.digitalinovatioone.PessoasAPI.enums.TipoTelefone;

public class TelefoneUtils {
    private static final Long ID =1L;
    private static final Integer DDD =11;
    private static final String NUMERO ="945783256";
    private static final TipoTelefone TIPO_TELEFONE= TipoTelefone.CELULAR;

    public static TelefoneDTO criaFakeDTO(){
        return TelefoneDTO.builder()
                .numero(NUMERO)
                .tipoTelefone(TIPO_TELEFONE)
                .ddd(DDD)
                .id(ID)
                .build();
    }
    public static Telefone criaFakeEntity(){
        return Telefone.builder()
                .numero(NUMERO)
                .tipoTelefone(TIPO_TELEFONE)
                .ddd(DDD)
                .id(ID)
                .build();
    }
}
