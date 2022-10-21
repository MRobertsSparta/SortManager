package com.sparta.mr.model.util;

public enum SorterOption {
    BUBBLE("Bubble Sort"),
    MERGE("Merge Sort"),
    TREE("Binary Tree Sort"),
    QUICK("Quick Sort"),
    INSERTION("Insertion Sort");

    private String name;

    SorterOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
