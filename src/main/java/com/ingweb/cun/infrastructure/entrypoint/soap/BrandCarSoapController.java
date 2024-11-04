package com.ingweb.cun.infrastructure.entrypoint.soap;

import com.ingweb.cun.application.dto.BrandCarDtoRequest;
import com.ingweb.cun.application.dto.BrandCarDtoResponse;
import com.ingweb.cun.application.dto.xml.BrandCarXml;
import com.ingweb.cun.domain.model.BrandCar;
import com.ingweb.cun.domain.usecase.IBrandCarServicePort;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@WebService
@RequiredArgsConstructor
public class BrandCarSoapController {

    private final IBrandCarServicePort brandCarService;


    @WebResult(name = "brandCarFound")
    public BrandCarXml getByIdXml(@WebParam(name = "idBrandCar") Integer idBrandCar) {
        Optional<BrandCarXml> xml = brandCarService.getById(idBrandCar).map(brandCarDominio -> {
            BrandCarXml brandCar = new BrandCarXml();
            brandCar.setIdBrand(brandCarDominio.getIdBrand());
            brandCar.setDescriptionBrand(brandCarDominio.getDescriptionBrand());
            return brandCar;
        });
        return xml.orElse(null);
    }

    // Si no coloco WebMethod, en SOAPUI se va a ver el mismo nombre que se escribio aqui en la firma del metodo
    @WebMethod(operationName = "consultar_por_id")
    // El WebResult tambien es OBLIGATORIO porque sino, en SOAPUI no me deja claro que objeto estoy devolviendo
    @WebResult(name = "brandCarFound")
    public BrandCar getById(@WebParam(name = "idBrandCar") Integer idBrandCar) {
        // El WebParam ES OBLIGATORIO para que no se vea un arg0
        return brandCarService.getById(idBrandCar).get();
    }

    @WebResult(name = "brandCarResponse")
    public BrandCarDtoResponse saveBrandCarDto(@WebParam(name = "brandCarDtoRequest") BrandCarDtoRequest brandCarDtoRequest) {
        return brandCarService.saveBrandCar(brandCarDtoRequest);
    }

    public BrandCarDtoResponse pruebaCamposRequeridos(@WebParam(name = "brandCarDtoRequest") @XmlElement(required = true) BrandCarXml brandCarXml) {
        return new BrandCarDtoResponse();
    }
}
