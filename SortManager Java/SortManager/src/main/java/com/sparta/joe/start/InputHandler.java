package com.sparta.joe.start;

import java.util.Scanner;

public class InputHandler {
    public static int searchSelect() {
        int sortSelected;
        startupText();

        try {
            Scanner scanner = new Scanner(System.in);
            sortSelected = scanner.nextInt();
        } catch (Exception invalidInput) {
            return 0;
        }
        return sortSelected;
    }

    public static int arraySize() {
        int arraySize;

        System.out.println("Please enter an array size");

        try {
            Scanner scanner = new Scanner(System.in);
            arraySize = scanner.nextInt();
        } catch (Exception invalidInput) {
            return 0;
        }
        return arraySize;
    }

    private static void startupText() {
        System.out.println("Available Sorters:");
        System.out.println("1: Bubble Sort");
        System.out.println("2: Insertion Sort");
        System.out.println("3: Merge Sort");
        System.out.println("4: Quick Sort");
        System.out.println("5: Selection Sort");
        System.out.println("6: Binary Tree Sort");
        System.out.println("Please enter the number of your selection");
    }
}
