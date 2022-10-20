package com.sparta.mr.model.util;

public enum SorterOption {
    BUBBLE("Bubble Sort"),
    MERGE("Merge Sort"),
    TREE("Binary Tree Sort");

    private String name;

    SorterOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}