package com.fernandocanabarro.cardboard_dio.models.dtos;

import java.util.List;

public record BoardColumnResponseDto(Long id, String name, Integer type, Integer position, Long boardId, List<CardResponseDto> cards) {

}
