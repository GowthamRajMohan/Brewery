package io.smacs.brewery.web.services.v2;

import io.smacs.brewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

/**
 * @author MGR on 11-01-2022
 */
public interface BeerServiceV2 {
    BeerDtoV2 findByBeerId(UUID id);
    BeerDtoV2 saveBeer(BeerDtoV2 beer);
    void updateBeer(UUID beerId, BeerDtoV2 beerDto);
    void deleteBeer(UUID beerId);
}
