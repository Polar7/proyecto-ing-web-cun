package com.ingweb.cun.infrastructure.entrypoint.rest;

import com.ingweb.cun.application.dto.BrandCarDtoRequest;
import com.ingweb.cun.application.dto.BrandCarDtoResponse;
import com.ingweb.cun.application.dto.CustomerDtoResponse;
import com.ingweb.cun.domain.model.BrandCar;
import com.ingweb.cun.domain.model.Customer;
import com.ingweb.cun.domain.usecase.ICustomerServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerServicePort customerService;

    @GetMapping(path = "{id}")
    public ResponseEntity<Customer> getById(@PathVariable String id) {
        return ResponseEntity.of(customerService.getById(id));
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PostMapping
    public ResponseEntity<CustomerDtoResponse> saveBrandCarDto(@Valid @RequestBody Customer brandCarDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.saveCustomer(brandCarDtoRequest));
    }
}
