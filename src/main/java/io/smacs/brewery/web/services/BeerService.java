package io.smacs.brewery.web.services;

import io.smacs.brewery.web.model.BeerDto;

import java.util.UUID;

/**
 * @author MGR on 11-12-2021
 */
public interface BeerService {
    BeerDto findByBeerId(UUID id);
    BeerDto saveBeer(BeerDto beer);
    void updateBeer(UUID beerId, BeerDto beerDto);
    void deleteBeer(UUID beerId);
}
