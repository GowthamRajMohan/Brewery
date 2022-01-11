package io.smacs.brewery.web.controller.v2;


import io.smacs.brewery.web.model.v2.BeerDtoV2;
import io.smacs.brewery.web.services.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author MGR on 11-01-2022
 */
@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.findByBeerId(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDtoV2> saveBeer(@RequestBody BeerDtoV2 beerDto){
        BeerDtoV2 savedBeer = beerServiceV2.saveBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location",
                "http://localhost:8080/api/v1/beer/"+savedBeer.getId().toString());
        return new ResponseEntity<>(httpHeaders,HttpStatus.CREATED);
    }
    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> updateBeer(@PathVariable("beerId")UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        beerServiceV2.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId")UUID beerId) {
        beerServiceV2.deleteBeer(beerId);
    }
}
