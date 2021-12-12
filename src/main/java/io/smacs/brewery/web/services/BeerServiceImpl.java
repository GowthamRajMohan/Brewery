package io.smacs.brewery.web.services;

import io.smacs.brewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author MGR on 11-12-2021
 */
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto findByBeerId(UUID id) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beer) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }
}
