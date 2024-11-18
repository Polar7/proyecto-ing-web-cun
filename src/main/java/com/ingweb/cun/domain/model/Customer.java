package com.ingweb.cun.domain.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


public class Customer {

    @NotEmpty(message = "El id no puede ser vacio")
    private String id;

    @NotEmpty(message = "El nombre no puede ser vacio")
    private String fullName;

    @NotNull(message = "El numero de telefono no puede ser nulo")
    private Double phone;

    @NotEmpty(message = "El email no puede ser vacio")
    private String email;

    @NotNull(message = "La fecha no puede ser nula")
    private LocalDateTime birthDay;

    /*
    @Valid
    private List<BrandCar> carros;
*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getPhone() {
        return phone;
    }

    public void setPhone(Double phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }


}
