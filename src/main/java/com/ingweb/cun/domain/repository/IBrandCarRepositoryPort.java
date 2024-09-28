package com.ingweb.cun.domain.repository;

import com.ingweb.cun.domain.model.BrandCar;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepositoryPort {

    Optional<BrandCar> getById(Integer idBrand);

    Optional<BrandCar> getByDescription(String brandCarDescription);

    List<BrandCar> getAllBrandCars();

    BrandCar save(String brandCarDescription);

    BrandCar update(BrandCar brandCar);

    void deleteById(Integer idBrand);
}
