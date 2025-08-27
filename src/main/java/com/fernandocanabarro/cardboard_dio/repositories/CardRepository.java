package com.fernandocanabarro.cardboard_dio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernandocanabarro.cardboard_dio.models.entities.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
