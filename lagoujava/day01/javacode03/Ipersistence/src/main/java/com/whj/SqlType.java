package com.whj;

import java.util.stream.Stream;

public enum SqlType {
    INSERT(0, "增"),
    DELETE(1, "删"),
    UPDATE(2, "改"),
    SELECT(3, "查");
    private int value;
    SqlType(int value, String text) {
        this.value = value;
    }
    public int value() {
        return this.value;
    }
    public static SqlType toType(int value) {
        return Stream.of(SqlType.values())
                .filter(c -> c.value == value)
                .findAny()
                .orElse(null);
    }
}
