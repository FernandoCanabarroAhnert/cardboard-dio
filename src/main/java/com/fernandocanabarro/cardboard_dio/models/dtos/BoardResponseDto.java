package com.fernandocanabarro.cardboard_dio.models.dtos;

import java.util.List;

public record BoardResponseDto(Long id, String name, List<BoardColumnResponseDto> columns) {

}
