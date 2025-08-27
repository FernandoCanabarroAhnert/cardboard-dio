package com.fernandocanabarro.cardboard_dio.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernandocanabarro.cardboard_dio.exceptions.NotFoundException;
import com.fernandocanabarro.cardboard_dio.mappers.CardMapper;
import com.fernandocanabarro.cardboard_dio.models.dtos.CardRequestDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.CardResponseDto;
import com.fernandocanabarro.cardboard_dio.models.entities.Board;
import com.fernandocanabarro.cardboard_dio.models.entities.BoardColumn;
import com.fernandocanabarro.cardboard_dio.models.entities.Card;
import com.fernandocanabarro.cardboard_dio.repositories.BoardColumnRepository;
import com.fernandocanabarro.cardboard_dio.repositories.BoardRepository;
import com.fernandocanabarro.cardboard_dio.repositories.CardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final BoardRepository boardRepository;
    private final BoardColumnRepository boardColumnRepository;

    @Transactional(readOnly = true)
    public CardResponseDto findCardById(Long id) {
        return this.cardRepository.findById(id)
            .map(CardMapper::toDto)
            .orElseThrow(() -> new NotFoundException("Card with id " + id + " not found"));
    }

    @Transactional
    public CardResponseDto createCard(Long boardId, CardRequestDto dto) {
        Board board = this.boardRepository.findById(boardId)
            .orElseThrow(() -> new NotFoundException("Board with id " + boardId + " not found"));
        Card card = CardMapper.toEntity(dto, board.getInitialColumn());
        return CardMapper.toDto(this.cardRepository.save(card));
    }

    @Transactional
    public CardResponseDto moveCard(Long cardId, Long targetColumnId) {
        Card card = this.cardRepository.findById(cardId)
            .orElseThrow(() -> new NotFoundException("Card with id " + cardId + " not found"));
        BoardColumn boardColumn = this.boardColumnRepository.findById(targetColumnId)
            .orElseThrow(() -> new NotFoundException("Board column with id " + targetColumnId + " not found"));
        if (!card.getBoardColumn().getBoard().containsColumn(targetColumnId)) {
            throw new NotFoundException("Target column with id " + targetColumnId + " not found in the same board as the card");
        }
        card.setBoardColumn(boardColumn);
        return CardMapper.toDto(this.cardRepository.save(card));
    }

}
