package com.pavan.msscbeerservice.service;

import com.pavan.msscbeerservice.domain.Beer;
import com.pavan.msscbeerservice.repository.BeerRepository;
import com.pavan.msscbeerservice.web.mappers.BeerMapper;
import com.pavan.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;
@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService{

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;


    @Override
    public BeerDto getById(UUID beerId) throws ChangeSetPersister.NotFoundException {
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) throws ChangeSetPersister.NotFoundException {

        Beer beer= beerRepository.findById(beerId).orElseThrow(ChangeSetPersister.NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
