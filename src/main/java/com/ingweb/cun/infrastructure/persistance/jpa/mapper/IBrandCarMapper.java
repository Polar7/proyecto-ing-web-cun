package com.ingweb.cun.infrastructure.persistance.jpa.mapper;

import com.ingweb.cun.domain.model.BrandCar;
import com.ingweb.cun.infrastructure.persistance.jpa.entity.BrandCarEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para convertir Entities o Models de BrandCar
 */
@Mapper(componentModel = "spring")
public interface IBrandCarMapper {

    /**
     * Transforma un objeto de dominio a una Entidad
     * @param brandCar Objeto de dominio como fuente
     * @return Entity mappeado
     */
    BrandCarEntity toBrandCarEntity(BrandCar brandCar);

    /**
     * Transforma una Entidad a un objeto de dominio
     * @param brandCarEntity Entity como fuente
     * @return Dto mappeado
     */
    BrandCar toBrandCar(BrandCarEntity brandCarEntity);
}
