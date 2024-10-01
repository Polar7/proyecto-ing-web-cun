package com.ingweb.cun.infrastructure.persistance.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "marca_coche")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandCarEntity {

    /**
     * Id de la MarcaCoche
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer idBrand;

    /**
     * Descripcion de la MarcaCoche
     */
    @Column(name = "descripcion_marca")
    private String descriptionBrand;


}
