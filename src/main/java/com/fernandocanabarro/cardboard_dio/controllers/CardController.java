package com.fernandocanabarro.cardboard_dio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandocanabarro.cardboard_dio.models.dtos.CardResponseDto;
import com.fernandocanabarro.cardboard_dio.services.CardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDto> findCardById(@PathVariable Long id) {
        return ResponseEntity.ok(this.cardService.findCardById(id));
    }

    @PutMapping("/{cardId}/board-column/{boardColumnId}")
    public ResponseEntity<CardResponseDto> moveCard(@PathVariable Long cardId, @PathVariable Long boardColumnId) {
        return ResponseEntity.ok(this.cardService.moveCard(cardId, boardColumnId));
    }

}
