package com.studentrest.entities;

import lombok.Getter;

@Getter
public enum Grade {
    TWO(2.0f), THREE(3.0f), THREE_PLUS(3.5f), FOUR(4.0f), FOUR_PLUS(4.5f), FIVE(5.0f);

    private Float value;

    Grade(Float value) {
        this.value = value;
    }
}
