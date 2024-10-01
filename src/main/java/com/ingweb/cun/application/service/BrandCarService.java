package com.ingweb.cun.application.service;

import com.ingweb.cun.application.dto.BrandCarDtoRequest;
import com.ingweb.cun.application.dto.BrandCarDtoResponse;
import com.ingweb.cun.domain.model.BrandCar;
import com.ingweb.cun.domain.repository.IBrandCarRepositoryPort;
import com.ingweb.cun.domain.usecase.IBrandCarServicePort;
import com.ingweb.cun.infrastructure.exception.BrandCarExistsException;
import com.ingweb.cun.infrastructure.exception.BrandCarNotExistsException;
import com.ingweb.cun.infrastructure.util.StatusCodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Adaptador para la MarcaCoche
 */
@Service
@RequiredArgsConstructor
public class BrandCarService implements IBrandCarServicePort {

    private final IBrandCarRepositoryPort brandCarRepository;

    @Override
    public Optional<BrandCar> getById(Integer idBrand) {
        return brandCarRepository.getById(idBrand);
    }

    @Override
    public List<BrandCar> getAllBrandCars() {
        return brandCarRepository.getAllBrandCars();
    }

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

    @Override
    public BrandCarDtoResponse update(BrandCar brandCar) {
        if (brandCarRepository.getById(brandCar.getIdBrand()).isEmpty()) {
            throw new BrandCarNotExistsException();
        }

        if (brandCarRepository.getByDescription(brandCar.getDescriptionBrand()).isPresent()) {
            throw new BrandCarExistsException();
        }

        brandCarRepository.update(brandCar);
        BrandCarDtoResponse brandCarDtoResponse = new BrandCarDtoResponse();
        brandCarDtoResponse.setCodeResponse(StatusCodeResponse.OK.getValueCode());
        brandCarDtoResponse.setMessageResponse(StatusCodeResponse.OK.getMessageStatus());
        return brandCarDtoResponse;
    }

    @Override
    public void deleteById(Integer idBrand) {
        if (brandCarRepository.getById(idBrand).isEmpty()) {
            throw new BrandCarNotExistsException();
        }
        brandCarRepository.deleteById(idBrand);
    }
}
