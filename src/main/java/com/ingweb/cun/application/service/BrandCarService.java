package com.ingweb.cun.application.service;

import com.ingweb.cun.application.dto.BrandCarDtoRequest;
import com.ingweb.cun.application.dto.BrandCarDtoResponse;
import com.ingweb.cun.domain.model.BrandCar;
import com.ingweb.cun.domain.repository.IBrandCarRepositoryPort;
import com.ingweb.cun.domain.usecase.IBrandCarServicePort;
import com.ingweb.cun.infrastructure.exception.BrandCarExistsException;
import com.ingweb.cun.infrastructure.util.StatusCodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Adaptador para la MarcaCoche
 */
@Service
@RequiredArgsConstructor
public class BrandCarService implements IBrandCarServicePort {

    private final IBrandCarRepositoryPort brandCarRepository;

    /**
     * Guarda una nueva marca coche
     * @param brandCarDtoRequest Descripcion de la marca a crear
     * @return Dto con la respuesta de la operacion
     */
    @Override
    public BrandCarDtoResponse saveBrandCar(BrandCarDtoRequest brandCarDtoRequest) {

        if (brandCarRepository.getByDescription(brandCarDtoRequest.getDescriptionBrand()).isPresent()) {
            throw new BrandCarExistsException();
        }
        
        BrandCar brandCar1 = brandCarRepository.save(brandCarDtoRequest.getDescriptionBrand());
        System.out.println("El marca cohce creado es: " + brandCar1);
        BrandCarDtoResponse brandCarDtoResponse = new BrandCarDtoResponse();
        brandCarDtoResponse.setCodeResponse(StatusCodeResponse.OK.getValueCode());
        brandCarDtoResponse.setMessageResponse(StatusCodeResponse.OK.getMessageStatus());
        return brandCarDtoResponse;
    }
}
