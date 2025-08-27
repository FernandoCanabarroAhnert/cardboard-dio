package com.fernandocanabarro.cardboard_dio.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBoardDto {

    private String name;
    private String initialColumnName;
    private String finalColumnName;
    private String cancelColumnName;
    private String[] pendingColumnsNames;

}
