package com.ingweb.cun.infrastructure.persistance.jpa.repository;

import com.ingweb.cun.domain.model.BrandCar;
import com.ingweb.cun.domain.repository.IBrandCarRepositoryPort;
import com.ingweb.cun.infrastructure.persistance.jpa.crud.IBrandCarCrudRepository;
import com.ingweb.cun.infrastructure.persistance.jpa.entity.BrandCarEntity;
import com.ingweb.cun.infrastructure.persistance.jpa.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BrandCarRepository implements IBrandCarRepositoryPort {

    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    private final IBrandCarMapper iBrandCarMapper;

    @Override
    public Optional<BrandCar> getById(Integer idBrand) {
        return iBrandCarCrudRepository
                .findById(idBrand)
                .map(iBrandCarMapper::toBrandCar);
    }

    @Override
    public Optional<BrandCar> getByDescription(String brandCarDescription) {
        return iBrandCarCrudRepository
                .findBrandCarByDescriptionBrand(brandCarDescription)
                .map(iBrandCarMapper::toBrandCar);
        /*
        Optional<BrandCarEntity> optionalBrandCar = iBrandCarCrudRepository.findBrandCarByDescriptionBrand(brandCarDescription);
        // El escenario exitoso porque NO DEBE EXISTIR una marca con la misma descripcion
        if (optionalBrandCar.isEmpty()) {
            return Optional.empty();
        }
        // Si ejecuta esto, es porque ya se encuentra repetido en la BD
        //return Optional.of(iBrandCarMapper.toBrandCar(optionalBrandCar.get()));
        return optionalBrandCar.map(iBrandCarMapper::toBrandCar);
        /** return optionalBrandCar.map(brandCarEntity -> {
         return iBrandCarMapper.toBrandCar(brandCarEntity);
         });*/
    }

    @Override
    public List<BrandCar> getAllBrandCars() {
        return iBrandCarCrudRepository.findAll().stream().map(actual -> {
            BrandCar brandCar = iBrandCarMapper.toBrandCar(actual);
            return brandCar;
        }).toList();
    }


    @Override
    public BrandCar save(String brandCarDescription) {
        BrandCarEntity brandCarEntity = new BrandCarEntity();
        brandCarEntity.setDescriptionBrand(brandCarDescription);
        return iBrandCarMapper.toBrandCar(iBrandCarCrudRepository.save(brandCarEntity));
        /** BrandCarEntity brandCarEntity2 = iBrandCarCrudRepository.save(brandCarEntity);
         BrandCar brandCar = new BrandCar();
         brandCar.setIdBrand(brandCarEntity2.getIdBrand());
         brandCar.setDescriptionBrand(brandCarEntity2.getDescriptionBrand());
         return brandCar;
         */
    }

    @Override
    public BrandCar update(BrandCar brandCar) {
        return iBrandCarMapper
                .toBrandCar(iBrandCarCrudRepository.save(iBrandCarMapper.toBrandCarEntity(brandCar)));
    }

    @Override
    public void deleteById(Integer idBrand) {
        iBrandCarCrudRepository.deleteById(idBrand);
    }
}
