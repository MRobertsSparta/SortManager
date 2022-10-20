package com.sparta.mr.model.util;

import com.sparta.mr.controller.logging.CustomLogger;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntArrayGenerator {

    private static final Logger logger = CustomLogger.getLogger();

    private static int[] generateRandomIntArray(int length) {
        logger.log(Level.INFO, "Generating random integer array of length " + length);
        Random r = new Random();
        int[] ints = new int[length];

        for (int i = 0; i < length; i++) {
            ints[i] = r.nextInt(0, 1000);
        }
        logger.log(Level.FINE, "Generated Array: " + Arrays.toString(ints));
        return ints;
    }
}
