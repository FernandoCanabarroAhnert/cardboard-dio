package com.fernandocanabarro.cardboard_dio.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBoardDto {

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "InitialColumnName is required")
    private String initialColumnName;
    @NotBlank(message = "FinalColumnName is required")
    private String finalColumnName;
    @NotBlank(message = "CancelColumnName is required")
    private String cancelColumnName;
    @NotEmpty(message = "PendingColumnsNames is required")
    private String[] pendingColumnsNames;

}
