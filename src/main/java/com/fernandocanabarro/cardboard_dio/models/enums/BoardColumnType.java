package com.fernandocanabarro.cardboard_dio.models.enums;

public enum BoardColumnType {
    INITIAL(1),
    FINAL(2),
    CANCEL(3),
    PENDING(4);

    private Integer value;

    BoardColumnType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static BoardColumnType fromValue(Integer value) {
        for (BoardColumnType type : BoardColumnType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid BoardColumnType value: " + value);
    }

}
