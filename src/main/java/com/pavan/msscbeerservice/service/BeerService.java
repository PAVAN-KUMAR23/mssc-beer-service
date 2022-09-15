package com.pavan.msscbeerservice.service;

import com.pavan.msscbeerservice.web.model.BeerDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {

    BeerDto getById(UUID beerId) throws ChangeSetPersister.NotFoundException;

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto) throws ChangeSetPersister.NotFoundException;
}
