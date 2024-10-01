package com.ingweb.cun.infrastructure.entrypoint.rest;

import com.ingweb.cun.application.dto.BrandCarDtoRequest;
import com.ingweb.cun.application.dto.BrandCarDtoResponse;
import com.ingweb.cun.domain.model.BrandCar;
import com.ingweb.cun.domain.usecase.IBrandCarServicePort;
import com.ingweb.cun.infrastructure.util.StatusCodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand-car")
@RequiredArgsConstructor
public class BrandCarController {

    private final IBrandCarServicePort brandCarService;

    @GetMapping(path = "{id}")
    public ResponseEntity<BrandCar> getById(@PathVariable Integer id) {
       return ResponseEntity.of(brandCarService.getById(id));
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<BrandCar>> getAll() {
        return ResponseEntity.ok(brandCarService.getAllBrandCars());
    }

    @PostMapping
    public ResponseEntity<BrandCarDtoResponse> saveBrandCarDto(@RequestBody BrandCarDtoRequest brandCarDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(brandCarService.saveBrandCar(brandCarDtoRequest));
    }

    @PutMapping
    public ResponseEntity<BrandCarDtoResponse> updateBrandCarDto(@RequestBody BrandCar brandCarDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandCarService.update(brandCarDtoRequest));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteBrandCarDto(@PathVariable Integer id) {
        brandCarService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
