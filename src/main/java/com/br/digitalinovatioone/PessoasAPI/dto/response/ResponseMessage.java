package com.br.digitalinovatioone.PessoasAPI.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {
    private String message;
}
