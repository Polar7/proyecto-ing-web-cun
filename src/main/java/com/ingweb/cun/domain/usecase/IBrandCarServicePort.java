package com.ingweb.cun.domain.usecase;

import com.ingweb.cun.application.dto.BrandCarDtoRequest;
import com.ingweb.cun.application.dto.BrandCarDtoResponse;
import com.ingweb.cun.domain.model.BrandCar;

import java.util.List;
import java.util.Optional;

/**
 * Puerto para la MarcaCoche
 */
public interface IBrandCarServicePort {

    Optional<BrandCar> getById(Integer idBrand);

    List<BrandCar> getAllBrandCars();

    /**
     * Guarda una nueva marca coche
     * @param brandCarDtoRequest Descripcion de la marca a crear
     * @return Dto con la respuesta de la operacion
     */
    BrandCarDtoResponse saveBrandCar(BrandCarDtoRequest brandCarDtoRequest);

    BrandCarDtoResponse update(BrandCar brandCar);

    void deleteById(Integer idBrand);
}
