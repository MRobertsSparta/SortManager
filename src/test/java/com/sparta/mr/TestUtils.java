package com.sparta.mr;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class TestUtils {

    public static int[] generateRandomIntArray() {
        Random r = new Random();
        int size = r.nextInt(101);
        int[] ints = new int[size];

        for (int i = 0; i < size; i++) {
            ints[i] = r.nextInt(201) - 100;
        }

        return ints;
    }

    public static Stream<int[]> getRandomIntArrayAsStream() {
        return Stream.of(generateRandomIntArray());
    }

    public static int[] generateRandomSortedIntArray() {
        int[] ints = generateRandomIntArray();
        Arrays.sort(ints);
        return ints;
    }

    public static Stream<int[]> getRandomSortedIntArrayAsStream() {
        return Stream.of(generateRandomSortedIntArray());
    }

    public static void reverseArray(int[] ints) {
        for (int i = 0; i < ints.length / 2; i++) {
            int temp = ints[i];
            ints[i] = ints[ints.length - i - 1];
            ints[ints.length - i - 1] = temp;
        }
    }

}
