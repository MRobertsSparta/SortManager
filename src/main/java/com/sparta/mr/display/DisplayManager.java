package com.sparta.mr.display;

import com.sparta.mr.start.SorterOption;

import java.util.Scanner;

public class DisplayManager {

    private static Scanner commandLineIn = new Scanner(System.in);

    public static SorterOption getSorterChoice() {
        System.out.println("Enter the number for the sorting algorithm you want to use: ");
        SorterOption[] options = SorterOption.values();
        for (int i = 0; i < options.length; i++) {
            System.out.println(" - (" + i + ") " + options[i].getName());
        }
        int choice = -1;
        do {
            try {
                System.out.print(">>> ");
                choice = commandLineIn.nextInt();
            } catch (NumberFormatException ex) {
                continue;
            }
        } while (choice < 0 || choice >= options.length);

        return options[choice];
    }

    public static void printSortResults() {

    }
}
