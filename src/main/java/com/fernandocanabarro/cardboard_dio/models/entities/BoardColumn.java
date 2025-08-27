package com.fernandocanabarro.cardboard_dio.models.entities;

import java.util.ArrayList;
import java.util.List;

import com.fernandocanabarro.cardboard_dio.models.enums.BoardColumnType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board_columns")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BoardColumnType type;
    @Column(nullable = false)
    private Integer position;
    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false, foreignKey = @ForeignKey(name = "fk_board_column_board", value = ConstraintMode.CONSTRAINT))
    private Board board;
    @OneToMany(mappedBy = "boardColumn", cascade = CascadeType.ALL)
    private List<Card> cards = new ArrayList<>();

}
