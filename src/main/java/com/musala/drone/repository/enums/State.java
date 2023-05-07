package com.musala.drone.repository.enums;

public enum State {

    IDLE('0'),
    LOADING('1'),
    LOADED('2'),
    DELIVERING('3'),
    DELIVERED('4'),
    RETURNING('5');

    public final char value;

    State(char value) {
        this.value = value;
    }
}
