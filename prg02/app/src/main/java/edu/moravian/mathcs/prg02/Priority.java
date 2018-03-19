package edu.moravian.mathcs.prg02;

/**
 * Created by meotm01 on 2/25/18.
 */

public enum Priority {

    LOW(0), NORMAL(1), HIGH(2);

    private int value;

    private Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Priority fromInt(int anInt) {
        switch (anInt) {
            case 0:
                return LOW;
            case 2:
                return HIGH;
            default:
                return NORMAL;
        }
    }
}
