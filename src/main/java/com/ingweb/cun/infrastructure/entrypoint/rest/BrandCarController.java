package com.ingweb.cun.infrastructure.entrypoint.rest;

import com.ingweb.cun.application.dto.BrandCarDtoRequest;
import com.ingweb.cun.application.dto.BrandCarDtoResponse;
import com.ingweb.cun.domain.usecase.IBrandCarServicePort;
import com.ingweb.cun.infrastructure.util.StatusCodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("brand-car")
@RequiredArgsConstructor
public class BrandCarController {

    private final IBrandCarServicePort brandCarService;


    @PostMapping
    public ResponseEntity<BrandCarDtoResponse> saveBrandCarDto(@RequestBody BrandCarDtoRequest brandCarDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(brandCarService.saveBrandCar(brandCarDtoRequest));
    }
}
