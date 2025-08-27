package com.fernandocanabarro.cardboard_dio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandocanabarro.cardboard_dio.models.dtos.BoardColumnResponseDto;
import com.fernandocanabarro.cardboard_dio.services.BoardColumnService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/board-columns")
@RequiredArgsConstructor
public class BoardColumnController {

    private final BoardColumnService boardColumnService;

    @GetMapping("/{id}")
    public ResponseEntity<BoardColumnResponseDto> findBoardColumnById(@PathVariable Long id) {
        return ResponseEntity.ok(this.boardColumnService.findBoardColumnById(id));
    }

}
