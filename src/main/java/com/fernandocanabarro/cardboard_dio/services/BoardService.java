package com.fernandocanabarro.cardboard_dio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernandocanabarro.cardboard_dio.exceptions.NotFoundException;
import com.fernandocanabarro.cardboard_dio.mappers.BoardMapper;
import com.fernandocanabarro.cardboard_dio.models.dtos.BoardResponseDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.CreateBoardDto;
import com.fernandocanabarro.cardboard_dio.models.entities.Board;
import com.fernandocanabarro.cardboard_dio.models.entities.BoardColumn;
import com.fernandocanabarro.cardboard_dio.models.enums.BoardColumnType;
import com.fernandocanabarro.cardboard_dio.repositories.BoardColumnRepository;
import com.fernandocanabarro.cardboard_dio.repositories.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardColumnRepository boardColumnRepository;

    @Transactional
    public BoardResponseDto findById(Long id) {
        Board board = this.boardRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Board with id " + id + " not found"));
        return BoardMapper.toDto(board);
    }

    @Transactional
    public BoardResponseDto createBoard(CreateBoardDto dto) {
        Board board = new Board();
        board.setName(dto.getName());
        board = boardRepository.save(board);

        List<BoardColumn> columns = new ArrayList<>();

        BoardColumn initialColumn = new BoardColumn();
        initialColumn.setName(dto.getInitialColumnName());
        initialColumn.setType(BoardColumnType.INITIAL);
        initialColumn.setPosition(0);
        initialColumn.setBoard(board);
        this.boardColumnRepository.save(initialColumn);
        columns.add(initialColumn);

        int additionalColumns = dto.getPendingColumnsNames().length;

        for (int i = 0; i < additionalColumns; i++) {
            BoardColumn pendingColumn = new BoardColumn();
            pendingColumn.setName(dto.getPendingColumnsNames()[i]);
            pendingColumn.setType(BoardColumnType.PENDING);
            pendingColumn.setPosition(i + 1);
            pendingColumn.setBoard(board);
            this.boardColumnRepository.save(pendingColumn);
            columns.add(pendingColumn);
        }

        BoardColumn finalColumn = new BoardColumn();
        finalColumn.setName(dto.getFinalColumnName());
        finalColumn.setType(BoardColumnType.FINAL);
        finalColumn.setPosition(additionalColumns + 1);
        finalColumn.setBoard(board);
        this.boardColumnRepository.save(finalColumn);
        columns.add(finalColumn);

        BoardColumn cancelColumn = new BoardColumn();
        cancelColumn.setName(dto.getCancelColumnName());
        cancelColumn.setType(BoardColumnType.CANCEL);
        cancelColumn.setPosition(additionalColumns + 2);
        cancelColumn.setBoard(board);
        this.boardColumnRepository.save(cancelColumn);
        columns.add(cancelColumn);

        board.setColumns(columns);

        return BoardMapper.toDto(board);
    }

    public void deleteBoard(Long id) {
        if (!this.boardRepository.existsById(id)) {
            throw new NotFoundException("Board with id " + id + " not found");
        }
        this.boardRepository.deleteById(id);
    }

}
