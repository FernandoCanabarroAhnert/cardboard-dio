package com.fernandocanabarro.cardboard_dio.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernandocanabarro.cardboard_dio.exceptions.NotFoundException;
import com.fernandocanabarro.cardboard_dio.mappers.BoardColumnMapper;
import com.fernandocanabarro.cardboard_dio.models.dtos.BoardColumnResponseDto;
import com.fernandocanabarro.cardboard_dio.repositories.BoardColumnRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardColumnService {

    private final BoardColumnRepository boardColumnRepository;

    @Transactional(readOnly = true)
    public BoardColumnResponseDto findBoardColumnById(Long id) {
        return boardColumnRepository.findById(id)
                .map(BoardColumnMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Board column with id " + id + " not found"));
    }

}
