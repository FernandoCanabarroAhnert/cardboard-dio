package com.fernandocanabarro.cardboard_dio.controllers.openapi;

import org.springframework.http.ResponseEntity;

import com.fernandocanabarro.cardboard_dio.models.dtos.BoardResponseDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.CardRequestDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.CardResponseDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.CreateBoardDto;
import com.fernandocanabarro.cardboard_dio.models.dtos.exceptions.StandardError;
import com.fernandocanabarro.cardboard_dio.models.dtos.exceptions.ValidationError;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface BoardControllerOpenAPI {

    @Operation(
        description = "Buscar um quadro pelo ID",
        summary = "Buscar quadro por ID",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Quadro encontrado",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = BoardResponseDto.class)
                    )
                }
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Quadro não encontrado",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = StandardError.class),
                        examples = @ExampleObject(
                            value = "{\r\n" +
                                    "    \"timestamp\": \"2025-08-27T18:05:13.528623200Z\",\r\n" + //
                                    "    \"status\": 404,\r\n" + //
                                    "    \"error\": \"Not Found\",\r\n" + //
                                    "    \"message\": \"Board with id 20 not found\",\r\n" + //
                                    "    \"path\": \"/boards/20\"\r\n" + //
                                    "}"
                        )
                    )
                }
            )
        }
    )
    public ResponseEntity<BoardResponseDto> findBoardById(Long id);

    @Operation(
        description = "Criar um quadro",
        summary = "Criar um novo quadro",
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "Quadro criado com sucesso",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = BoardResponseDto.class)
                    )
                }
            ),
            @ApiResponse(
                responseCode = "422",
                description = "Quadro inválido",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ValidationError.class),
                        examples = @ExampleObject(
                            value = "{\r\n" + //
                                    "    \"timestamp\": \"2025-08-27T18:22:14.659371700Z\",\r\n" + //
                                    "    \"status\": 422,\r\n" + //
                                    "    \"error\": \"Unprocessable Entity\",\r\n" + //
                                    "    \"message\": \"Validation error\",\r\n" + //
                                    "    \"path\": \"/boards\",\r\n" + //
                                    "    \"errors\": [\r\n" + //
                                    "        {\r\n" + //
                                    "            \"fieldName\": \"name\",\r\n" + //
                                    "            \"message\": \"Name is required\"\r\n" + //
                                    "        }\r\n" + //
                                    "    ]\r\n" + //
                                    "}"
                        )
                    )
                }
            )
        }
    )
    public ResponseEntity<BoardResponseDto> createBoard(CreateBoardDto dto);

    @Operation(
        description = "Deletar um quadro pelo ID",
        summary = "Deletar quadro por ID",
        responses = {
            @ApiResponse(
                responseCode = "204",
                description = "Quadro deletado com sucesso",
                content = {
                    @Content(
                        mediaType = "application/json"
                    )
                }
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Quadro não encontrado",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = StandardError.class),
                        examples = @ExampleObject(
                            value = "{\r\n" +
                                    "    \"timestamp\": \"2025-08-27T18:05:13.528623200Z\",\r\n" + //
                                    "    \"status\": 404,\r\n" + //
                                    "    \"error\": \"Not Found\",\r\n" + //
                                    "    \"message\": \"Board with id 20 not found\",\r\n" + //
                                    "    \"path\": \"/boards/20\"\r\n" + //
                                    "}"
                        )
                    )
                }
            )
        }
    )
    public ResponseEntity<Void> deleteBoard(Long id);

    @Operation(
        description = "Criar uma tarefa",
        summary = "Criar uma nova tarefa",
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "Tarefa criada com sucesso",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = CardResponseDto.class)
                    )
                }
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Quadro não encontrado",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = StandardError.class),
                        examples = @ExampleObject(
                            value = "{\r\n" +
                                    "    \"timestamp\": \"2025-08-27T18:05:13.528623200Z\",\r\n" + //
                                    "    \"status\": 404,\r\n" + //
                                    "    \"error\": \"Not Found\",\r\n" + //
                                    "    \"message\": \"Board with id 20 not found\",\r\n" + //
                                    "    \"path\": \"/boards/20\"\r\n" + //
                                    "}"
                        )
                    )
                }
            ),
            @ApiResponse(
                responseCode = "422",
                description = "Tarefa inválida",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ValidationError.class),
                        examples = @ExampleObject(
                            value = "{\r\n" + //
                                    "    \"timestamp\": \"2025-08-27T18:22:14.659371700Z\",\r\n" + //
                                    "    \"status\": 422,\r\n" + //
                                    "    \"error\": \"Unprocessable Entity\",\r\n" + //
                                    "    \"message\": \"Validation error\",\r\n" + //
                                    "    \"path\": \"/boards\",\r\n" + //
                                    "    \"errors\": [\r\n" + //
                                    "        {\r\n" + //
                                    "            \"fieldName\": \"title\",\r\n" + //
                                    "            \"message\": \"Title is required\"\r\n" + //
                                    "        },\r\n" + //
                                    "        {\r\n" + //
                                    "            \"fieldName\": \"description\",\r\n" + //
                                    "            \"message\": \"Description is required\"\r\n" + //
                                    "        }\r\n" + //
                                    "    ]\r\n" + //
                                    "}"
                        )
                    )
                }
            )
        }
    )
    public ResponseEntity<CardResponseDto> createCard(Long boardId, CardRequestDto dto);

}
