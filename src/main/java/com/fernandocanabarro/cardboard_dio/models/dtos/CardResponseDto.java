package com.fernandocanabarro.cardboard_dio.models.dtos;

import java.time.LocalDateTime;

public record CardResponseDto(Long id, String title, String description, LocalDateTime createdAt, Long boardColumnId) {

}
