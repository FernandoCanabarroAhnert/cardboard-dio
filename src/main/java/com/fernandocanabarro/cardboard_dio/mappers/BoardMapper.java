package com.fernandocanabarro.cardboard_dio.mappers;

import java.util.List;

import com.fernandocanabarro.cardboard_dio.models.dtos.BoardColumnResponseDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.BoardResponseDto;
import com.fernandocanabarro.cardboard_dio.models.entities.Board;

public class BoardMapper {

    public static BoardResponseDto toDto(Board board) {
        List<BoardColumnResponseDto> boardColumnResponseDtos = board.getColumns().stream()
            .map(BoardColumnMapper::toDto)
            .toList();
        return new BoardResponseDto(board.getId(), board.getName(), boardColumnResponseDtos);
    }

}
