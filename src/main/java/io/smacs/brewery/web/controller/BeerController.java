package io.smacs.brewery.web.controller;

import io.smacs.brewery.web.model.BeerDto;
import io.smacs.brewery.web.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author MGR on 11-12-2021
 */
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.findByBeerId(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveBeer(@RequestBody BeerDto beerDto){
        BeerDto savedBeer = beerService.saveBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location",
                "http://localhost:8080/api/v1/beer/"+savedBeer.getId().toString());
        return new ResponseEntity<>(httpHeaders,HttpStatus.CREATED);
    }
    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeer(@PathVariable("beerId")UUID beerId, @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId")UUID beerId) {
        beerService.deleteBeer(beerId);
    }
}
