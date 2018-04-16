package com.marcin.jedrusiak.model;

public class Number {
    private long value;
    private int index;

    public Number() {
    }

    public Number(long value, int index) {
        this.value = value;
        this.index = index;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
