package com.ingweb.cun.domain.repository;

import com.ingweb.cun.application.dto.CustomerDtoResponse;
import com.ingweb.cun.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepositoryPort {

    Optional<Customer> getById(String id);

    List<Customer> getAllCustomer();

    Customer saveCustomer(Customer customerDtoRequest);
}
