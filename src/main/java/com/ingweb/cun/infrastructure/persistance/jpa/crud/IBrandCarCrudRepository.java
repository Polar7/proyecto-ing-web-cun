package com.ingweb.cun.infrastructure.persistance.jpa.crud;


import com.ingweb.cun.infrastructure.persistance.jpa.entity.BrandCarEntity;
import jakarta.persistence.NamedNativeQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Interfaz para el CRUD de MarcaCoche
 */
public interface IBrandCarCrudRepository extends JpaRepository<BrandCarEntity, Integer> {

    // Query methods
    Optional<BrandCarEntity> findBrandCarByDescriptionBrand(String descriptionBrand);


}
