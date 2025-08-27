package com.fernandocanabarro.cardboard_dio.controllers.openapi;

import org.springframework.http.ResponseEntity;

import com.fernandocanabarro.cardboard_dio.models.dtos.CardResponseDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.exceptions.StandardError;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface CardControllerOpenAPI {

    @Operation(
        description = "Buscar uma tarefa pelo ID",
        summary = "Buscar tarefa por ID",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Tarefa encontrada",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = CardResponseDto.class)
                    )
                }
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Tarefa não encontrada",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = StandardError.class),
                        examples = @ExampleObject(
                            value = "{\r\n" +
                                    "    \"timestamp\": \"2025-08-27T18:05:13.528623200Z\",\r\n" + //
                                    "    \"status\": 404,\r\n" + //
                                    "    \"error\": \"Not Found\",\r\n" + //
                                    "    \"message\": \"Card with id 20 not found\",\r\n" + //
                                    "    \"path\": \"/cards/20\"\r\n" + //
                                    "}"
                        )
                    )
                }
            )
        }
    )
    public ResponseEntity<CardResponseDto> findCardById(Long id);

    @Operation(
        description = "Mover uma tarefa pelo seu ID e para uma nova coluna",
        summary = "Mover tarefa por ID",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Tarefa movida",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = CardResponseDto.class)
                    )
                }
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Tarefa ou Coluna do quadro não encontrada",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = StandardError.class),
                        examples = @ExampleObject(
                            value = "{\r\n" +
                                    "    \"timestamp\": \"2025-08-27T18:05:13.528623200Z\",\r\n" + //
                                    "    \"status\": 404,\r\n" + //
                                    "    \"error\": \"Not Found\",\r\n" + //
                                    "    \"message\": \"Card with id 20 not found\",\r\n" + //
                                    "    \"path\": \"/cards/20\"\r\n" + //
                                    "}"
                        )
                    )
                }
            )
        }
    )
    public ResponseEntity<CardResponseDto> moveCard(Long cardId, Long boardColumnId);

}
