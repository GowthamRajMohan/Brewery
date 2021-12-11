package io.smacs.brewery.web.services;

import io.smacs.brewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author MGR on 11-12-2021
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto findById(UUID id) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Gowtham")
                .build();
    }
}
