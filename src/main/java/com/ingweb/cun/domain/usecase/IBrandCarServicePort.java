package com.ingweb.cun.domain.usecase;

import com.ingweb.cun.application.dto.BrandCarDtoRequest;
import com.ingweb.cun.application.dto.BrandCarDtoResponse;

/**
 * Puerto para la MarcaCoche
 */
public interface IBrandCarServicePort {

    /**
     * Guarda una nueva marca coche
     * @param brandCarDtoRequest Descripcion de la marca a crear
     * @return Dto con la respuesta de la operacion
     */
    BrandCarDtoResponse saveBrandCar(BrandCarDtoRequest brandCarDtoRequest);
}
