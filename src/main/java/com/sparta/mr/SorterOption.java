package com.sparta.mr;

public enum SorterOption {
    BUBBLE_SORT("Bubble Sort");

    String name;

    SorterOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
