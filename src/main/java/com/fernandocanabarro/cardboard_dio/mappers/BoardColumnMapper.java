package com.fernandocanabarro.cardboard_dio.mappers;

import com.fernandocanabarro.cardboard_dio.models.dtos.BoardColumnResponseDto;
import com.fernandocanabarro.cardboard_dio.models.entities.Board;
import com.fernandocanabarro.cardboard_dio.models.entities.BoardColumn;
import com.fernandocanabarro.cardboard_dio.models.enums.BoardColumnType;

public class BoardColumnMapper {

    public static BoardColumn toEntity(String name, BoardColumnType type, Integer position, Board board) {
        BoardColumn boardColumn = new BoardColumn();
        boardColumn.setName(name);
        boardColumn.setType(type);
        boardColumn.setPosition(position);
        boardColumn.setBoard(board);
        return boardColumn;
    }

    public static BoardColumnResponseDto toDto(BoardColumn boardColumn) {
        return new BoardColumnResponseDto(boardColumn.getId(),
            boardColumn.getName(),
            boardColumn.getType().getValue(),
            boardColumn.getPosition(),
            boardColumn.getBoard().getId(),
            boardColumn.getCards().stream().map(CardMapper::toDto).toList());
    }
    
}
