package io.smacs.brewery.web.services;

import io.smacs.brewery.web.BeerDto;

import java.util.UUID;

/**
 * @author MGR on 11-12-2021
 */
public interface BeerService {
    BeerDto findByBeerId(UUID id);
}