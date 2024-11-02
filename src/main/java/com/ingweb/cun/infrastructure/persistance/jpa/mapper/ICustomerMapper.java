package com.ingweb.cun.infrastructure.persistance.jpa.mapper;

import com.ingweb.cun.domain.model.Customer;
import com.ingweb.cun.infrastructure.persistance.jpa.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {


    Customer toDto(CustomerEntity customerEntity);

    CustomerEntity toEntity(Customer customer);


}
