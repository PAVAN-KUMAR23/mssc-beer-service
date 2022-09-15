package com.pavan.msscbeerservice.web.mappers;

import com.pavan.msscbeerservice.domain.Beer;
import com.pavan.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto beerDto);

}
