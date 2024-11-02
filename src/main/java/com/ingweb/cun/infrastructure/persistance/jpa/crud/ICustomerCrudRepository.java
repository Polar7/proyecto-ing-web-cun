package com.ingweb.cun.infrastructure.persistance.jpa.crud;

import com.ingweb.cun.domain.model.Customer;
import com.ingweb.cun.infrastructure.persistance.jpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerCrudRepository extends JpaRepository<CustomerEntity, String> {

    //Optional<CustomerEntity> findBy(String customerId);
}
