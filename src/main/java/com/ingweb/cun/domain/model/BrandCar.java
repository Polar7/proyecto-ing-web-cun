package com.ingweb.cun.domain.model;

/**
 * Moldeo un objeto de dominio de una MarcaCoche
 */
public class BrandCar {

    /**
     * Id de la MarcaCoche
     */
    private Integer idBrand;

    /**
     * Descripcion de la MarcaCoche
     */
    private String descriptionBrand;

    public Integer getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }

    public String getDescriptionBrand() {
        return descriptionBrand;
    }

    public void setDescriptionBrand(String descriptionBrand) {
        this.descriptionBrand = descriptionBrand;
    }

    public BrandCar(Integer idBrand, String descriptionBrand) {
        this.idBrand = idBrand;
        this.descriptionBrand = descriptionBrand;
    }

    public BrandCar() {
    }

    @Override
    public String toString() {
        return "BrandCar{" +
                "idBrand=" + idBrand +
                ", descriptionBrand='" + descriptionBrand + '\'' +
                '}';
    }
}
