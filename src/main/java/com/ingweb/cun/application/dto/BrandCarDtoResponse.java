package com.ingweb.cun.application.dto;

import com.ingweb.cun.infrastructure.util.StatusCodeResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Moldea un MarcaCocheDto para las respuesta
 */
@Getter
@Setter
public class BrandCarDtoResponse {

    private Integer codeResponse;

    private String messageResponse;
}
