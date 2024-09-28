package com.ingweb.cun.domain.repository;

import com.ingweb.cun.domain.model.BrandCar;

import java.util.Optional;

public interface IBrandCarRepositoryPort {

    Optional<BrandCar> getByDescription(String brandCarDescription);

    BrandCar save(String brandCarDescription);
}
