package com.ingweb.cun.application.dto.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Moldeo un DTO XML de una MarcaCoche
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "brandCarXml")
@XmlAccessorType(XmlAccessType.FIELD)
public class BrandCarXml {

    /**
     * Id de la MarcaCoche
     */
    @XmlElement(name = "idmarcacoche", required = true, namespace = "")
    private Integer idBrand;

    /**
     * Descripcion de la MarcaCoche
     */
    @XmlElement(name = "descripcion_de_la_marca_coche", required = true, namespace = "")
    private String descriptionBrand;
}
