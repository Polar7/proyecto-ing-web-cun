package com.ingweb.cun.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Moldea un MarcaCocheDto para las peticiones
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandCarDtoRequest {

    /**
     * Descripcion de la MarcaCoche
     */
    private String descriptionBrand;
}
