package com.pavan.msscbeerservice.repository;

import com.pavan.msscbeerservice.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
