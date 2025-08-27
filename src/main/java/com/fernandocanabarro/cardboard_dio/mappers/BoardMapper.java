package com.fernandocanabarro.cardboard_dio.mappers;

import java.util.List;

import com.fernandocanabarro.cardboard_dio.models.dtos.BoardColumnResponseDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.BoardResponseDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.CardResponseDto;
import com.fernandocanabarro.cardboard_dio.models.entities.Board;

public class BoardMapper {

    public static BoardResponseDto toDto(Board board) {
        List<BoardColumnResponseDto> boardColumnResponseDtos = board.getColumns().stream()
            .map(boardColumn -> {
                return new BoardColumnResponseDto(boardColumn.getId(),
                        boardColumn.getName(),
                        boardColumn.getType().getValue(),
                        boardColumn.getPosition(),
                        boardColumn.getBoard().getId(),
                        boardColumn.getCards().stream()
                                .map(card -> new CardResponseDto(card.getId(), card.getTitle(),
                                        card.getDescription(), card.getCreatedAt(), card.getBoardColumn().getId()))
                                .toList());
            })
            .toList();
        return new BoardResponseDto(board.getId(), board.getName(), boardColumnResponseDtos);
    }

}
