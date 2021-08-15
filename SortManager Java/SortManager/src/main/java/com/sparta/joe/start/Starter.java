package com.sparta.joe.start;

import com.sparta.joe.sorters.Sorter;
import com.sparta.joe.util.ArrayPrinter;
import com.sparta.joe.util.RandomArray;

import java.util.Scanner;

public class Starter {
    public static void start() {
        int[] unsortedArray = RandomArray.randomIntArray(10, 1, 50);

        startupText();

        Scanner scanner = new Scanner(System.in);
        int sortSelected = scanner.nextInt();

        Sorter sorter = SortFactory.getSorter(sortSelected, unsortedArray);

        System.out.println("Unsorted Array:");
        ArrayPrinter.arrayPrint(unsortedArray);

        System.out.println("Sorted Array:");

        double startTime = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        double endTime = System.nanoTime();

        ArrayPrinter.arrayPrint(sortedArray);
        System.out.println("Total time taken: " + (endTime-startTime) + " nanoseconds.");


    }

    private static void startupText() {
        System.out.println("Welcome to the Sort Manager program!");
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
