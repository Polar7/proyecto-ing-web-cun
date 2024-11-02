package com.ingweb.cun.domain.usecase;

import com.ingweb.cun.application.dto.CustomerDtoResponse;
import com.ingweb.cun.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerServicePort {

    Optional<Customer> getById(String id);

    List<Customer> getAllCustomer();

    CustomerDtoResponse saveCustomer(Customer customerDtoRequest);
}
