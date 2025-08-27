package com.fernandocanabarro.cardboard_dio.mappers;

import java.time.LocalDateTime;

import com.fernandocanabarro.cardboard_dio.models.dtos.CardRequestDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.CardResponseDto;
import com.fernandocanabarro.cardboard_dio.models.entities.BoardColumn;
import com.fernandocanabarro.cardboard_dio.models.entities.Card;

public class CardMapper {

    public static Card toEntity(CardRequestDto dto, BoardColumn boardColumn) {
        Card card = new Card();
        card.setTitle(dto.getTitle());
        card.setDescription(dto.getDescription());
        card.setCreatedAt(LocalDateTime.now());
        card.setBoardColumn(boardColumn);
        return card;
    }

    public static CardResponseDto toDto(Card card) {
        return new CardResponseDto(card.getId(), card.getTitle(),
            card.getDescription(), card.getCreatedAt(), card.getBoardColumn().getId());
    }

}
