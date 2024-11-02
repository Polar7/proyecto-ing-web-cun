package com.ingweb.cun.infrastructure.persistance.jpa.repository;

import com.ingweb.cun.application.dto.CustomerDtoResponse;
import com.ingweb.cun.domain.model.BrandCar;
import com.ingweb.cun.domain.model.Customer;
import com.ingweb.cun.domain.repository.ICustomerRepositoryPort;
import com.ingweb.cun.infrastructure.persistance.jpa.crud.ICustomerCrudRepository;
import com.ingweb.cun.infrastructure.persistance.jpa.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepository implements ICustomerRepositoryPort {

    private final ICustomerCrudRepository customerCrudRepository;

    private final ICustomerMapper customerMapper;

    @Override
    public Optional<Customer> getById(String id) {
        return customerCrudRepository
                .findById(id)
                .map(customerMapper::toDto);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerCrudRepository.findAll().stream().map(customerMapper::toDto).toList();
    }

    @Override
    public Customer saveCustomer(Customer customerDtoRequest) {
        return customerMapper.toDto(customerCrudRepository.save(customerMapper.toEntity(customerDtoRequest)));
    }
}
