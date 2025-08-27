package com.fernandocanabarro.cardboard_dio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandocanabarro.cardboard_dio.models.dtos.BoardResponseDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.CardRequestDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.CardResponseDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.CreateBoardDto;
import com.fernandocanabarro.cardboard_dio.services.BoardService;
import com.fernandocanabarro.cardboard_dio.services.CardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final CardService cardService;

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDto> findBoardById(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody @Valid CreateBoardDto dto) {
        return ResponseEntity.status(201).body(boardService.createBoard(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        this.boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{boardId}/cards")
    public ResponseEntity<CardResponseDto> createCard(@PathVariable Long boardId, @RequestBody @Valid CardRequestDto dto) {
        return ResponseEntity.status(201).body(this.cardService.createCard(boardId, dto));
    }

}
