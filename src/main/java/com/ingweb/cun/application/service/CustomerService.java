package com.ingweb.cun.application.service;

import com.ingweb.cun.application.dto.CustomerDtoResponse;
import com.ingweb.cun.domain.model.Customer;
import com.ingweb.cun.domain.repository.ICustomerRepositoryPort;
import com.ingweb.cun.domain.usecase.ICustomerServicePort;
import com.ingweb.cun.infrastructure.exception.BrandCarExistsException;
import com.ingweb.cun.infrastructure.exception.BrandCarNotExistsException;
import com.ingweb.cun.infrastructure.exception.FormatEmailException;
import com.ingweb.cun.infrastructure.util.StatusCodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerServicePort {

    private final ICustomerRepositoryPort customerRepository;

    @Override
    public Optional<Customer> getById(String id) {
        return customerRepository.getById(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public CustomerDtoResponse saveCustomer(Customer customerDtoRequest) {

        if (!isValidEmail(customerDtoRequest.getEmail())) {
            throw new FormatEmailException();
        }

        customerRepository.saveCustomer(customerDtoRequest);
        CustomerDtoResponse customerDtoResponse = new CustomerDtoResponse();
        customerDtoResponse.setCodeResponse(StatusCodeResponse.OK.getValueCode());
        customerDtoResponse.setMessageResponse(StatusCodeResponse.OK.getMessageStatus());
        return customerDtoResponse;
    }

    /**
     * Valida si el email de una cadena cumple el debido formato
     * @param email Email a validar
     * @return True si cumple la regex, false de lo contrario
     */
    private boolean isValidEmail(String email) {
        return Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", email);
    }

    private void prueba() {
        RuntimeException papa = new RuntimeException();
        RuntimeException hijo1 = new BrandCarExistsException();
        RuntimeException hijo2 = new BrandCarNotExistsException();
        RuntimeException hijo3 = new FormatEmailException();

        ArithmeticException hijo4 = new ArithmeticException();
    }
}
