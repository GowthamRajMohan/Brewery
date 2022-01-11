package io.smacs.brewery.web.services;

import io.smacs.brewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author MGR on 11-12-2021
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto findById(UUID id) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Gowtham")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) {
        return null;
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting customer {}", customerId);
    }
}
