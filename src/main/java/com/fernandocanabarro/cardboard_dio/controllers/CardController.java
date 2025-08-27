package com.fernandocanabarro.cardboard_dio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandocanabarro.cardboard_dio.controllers.openapi.CardControllerOpenAPI;
import com.fernandocanabarro.cardboard_dio.models.dtos.CardResponseDto;
import com.fernandocanabarro.cardboard_dio.services.CardService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
@Tag(name = "Card", description = "Gerencia as tarefas (cards) do quadro")
public class CardController implements CardControllerOpenAPI {

    private final CardService cardService;

    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDto> findCardById(@Parameter(description = "ID da tarefa") @PathVariable Long id) {
        return ResponseEntity.ok(this.cardService.findCardById(id));
    }

    @PutMapping("/{cardId}/board-column/{boardColumnId}")
    public ResponseEntity<CardResponseDto> moveCard(@Parameter(description = "ID da tarefa") @PathVariable Long cardId, @Parameter(description = "ID da coluna do quadro") @PathVariable Long boardColumnId) {
        return ResponseEntity.ok(this.cardService.moveCard(cardId, boardColumnId));
    }

}
