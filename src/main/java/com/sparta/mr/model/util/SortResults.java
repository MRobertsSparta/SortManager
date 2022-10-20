package com.sparta.mr.model.util;

public class SortResults {

    private int[] initialArray;
    private int[] sortedArray;
    private long timeTakenNano;

    public SortResults(int[] initialArray, int[] sortedArray, long timeTakenNano) {
        this.initialArray = initialArray;
        this.sortedArray = sortedArray;
        this.timeTakenNano = timeTakenNano;
    }

    public int[] getInitialArray() {
        return initialArray;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public long getTimeTakenNano() {
        return timeTakenNano;
    }
}
