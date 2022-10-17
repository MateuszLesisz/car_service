package com.infoshareacademy.car_service.dto;

public enum Color {
    BLUE("Blue"),
    WHITE("White"),
    BLACK("Black"),
    YELLOW("Yellow"),
    GREY("Grey"),
    PURPLE("Purple"),
    GREEN("Green"),
    SILVER("Silver"),
    ORANGE("Orange"),
    PINK("Pink"),
    ;

    private final String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
