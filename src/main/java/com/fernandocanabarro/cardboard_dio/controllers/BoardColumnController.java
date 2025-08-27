package com.fernandocanabarro.cardboard_dio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandocanabarro.cardboard_dio.controllers.openapi.BoardColumnControllerOpenAPI;
import com.fernandocanabarro.cardboard_dio.models.dtos.BoardColumnResponseDto;
import com.fernandocanabarro.cardboard_dio.services.BoardColumnService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/board-columns")
@RequiredArgsConstructor
@Tag(name = "Board Columns", description = "Endpoints para gerenciar colunas de um quadro de tarefas")
public class BoardColumnController implements BoardColumnControllerOpenAPI {

    private final BoardColumnService boardColumnService;

    @GetMapping("/{id}")
    public ResponseEntity<BoardColumnResponseDto> findBoardColumnById(@Parameter(description = "ID da coluna do quadro") @PathVariable Long id) {
        return ResponseEntity.ok(this.boardColumnService.findBoardColumnById(id));
    }

}
