package com.fernandocanabarro.cardboard_dio.models.entities;

import java.util.ArrayList;
import java.util.List;

import com.fernandocanabarro.cardboard_dio.models.enums.BoardColumnType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "boards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<BoardColumn> columns = new ArrayList<>();


    public BoardColumn getInitialColumn() {
        return this.columns.stream()
            .filter(boardColumn -> boardColumn.getType().equals(BoardColumnType.INITIAL))
            .findFirst()
            .orElse(null);
    }

    public BoardColumn getFinalColumn() {
        return this.columns.stream()
            .filter(boardColumn -> boardColumn.getType().equals(BoardColumnType.FINAL))
            .findFirst()
            .orElse(null);
    }

    public BoardColumn getCancelColumn() {
        return this.columns.stream()
            .filter(boardColumn -> boardColumn.getType().equals(BoardColumnType.CANCEL))
            .findFirst()
            .orElse(null);
    }

    public boolean containsColumn(Long columnId) {
        return this.columns.stream().anyMatch(col -> col.getId().equals(columnId));
    }

}
