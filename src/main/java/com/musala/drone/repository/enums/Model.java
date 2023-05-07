package com.musala.drone.repository.enums;

public enum Model {

    LIGHTWEIGHT('0'),
    MIDDLEWEIGHT('1'),
    CRUISERWEIGHT('2'),
    HEAVYWEIGHT('3');

    public final char value;

    Model(char value) {
        this.value = value;
    }

}
