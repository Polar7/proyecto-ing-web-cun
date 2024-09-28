package com.ingweb.cun.infrastructure.persistance.jpa.repository;

import com.ingweb.cun.domain.model.BrandCar;
import com.ingweb.cun.domain.repository.IBrandCarRepositoryPort;
import com.ingweb.cun.infrastructure.persistance.jpa.crud.IBrandCarCrudRepository;
import com.ingweb.cun.infrastructure.persistance.jpa.entity.BrandCarEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BrandCarRepository implements IBrandCarRepositoryPort {

    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    @Override
    public Optional<BrandCar> getByDescription(String brandCarDescription) {
        BrandCar brandCar = new BrandCar();
        Optional<BrandCarEntity> optionalBrandCar = iBrandCarCrudRepository.findBrandCarByDescriptionBrand(brandCarDescription);


        // El escenario exitoso porque NO DEBE EXISTIR una marca con la misma descripcion
        if (optionalBrandCar.isEmpty()) {
           return Optional.empty();
        }

        // Si ejecuta esto, es porque ya se encuentra repetido en la BD
        BrandCarEntity brandCarEntity = optionalBrandCar.get();
        brandCar.setIdBrand(brandCarEntity.getIdBrand());
        brandCar.setDescriptionBrand(brandCarEntity.getDescriptionBrand());
        return Optional.of(brandCar);
    }

    @Override
    public BrandCar save(String brandCarDescription) {
        BrandCarEntity brandCarEntity = new BrandCarEntity();
        brandCarEntity.setDescriptionBrand(brandCarDescription);
        BrandCarEntity brandCarEntity2 = iBrandCarCrudRepository.save(brandCarEntity);
        BrandCar brandCar = new BrandCar();
        brandCar.setIdBrand(brandCarEntity2.getIdBrand());
        brandCar.setDescriptionBrand(brandCarEntity2.getDescriptionBrand());
        return brandCar;
    }
}
