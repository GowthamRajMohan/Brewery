package io.smacs.brewery.web.services;

import io.smacs.brewery.web.model.CustomerDto;

import java.util.UUID;

/**
 * @author MGR on 11-12-2021
 */
public interface CustomerService {
    CustomerDto findById(UUID id);
    CustomerDto saveCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto);
    void deleteCustomer(UUID customerId);
}
