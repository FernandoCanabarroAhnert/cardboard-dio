package com.fernandocanabarro.cardboard_dio.controllers.openapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.fernandocanabarro.cardboard_dio.models.dtos.BoardColumnResponseDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.exceptions.StandardError;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface BoardColumnControllerOpenAPI {

    @GetMapping("/{id}")
    @Operation(
        description = "Buscar uma coluna pelo ID",
        summary = "Buscar coluna por ID",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Coluna encontrada",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = BoardColumnResponseDto.class)
                    )
                }
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Coluna não encontrada",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = StandardError.class),
                        examples = @ExampleObject(
                            value = "{\r\n" +
                                    "    \"timestamp\": \"2025-08-27T18:05:13.528623200Z\",\r\n" + //
                                    "    \"status\": 404,\r\n" + //
                                    "    \"error\": \"Not Found\",\r\n" + //
                                    "    \"message\": \"Board column with id 20 not found\",\r\n" + //
                                    "    \"path\": \"/board-columns/20\"\r\n" + //
                                    "}"
                        )
                    )
                }
            )
        }
    )
    ResponseEntity<BoardColumnResponseDto> findBoardColumnById(Long id);

}
