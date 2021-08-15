package com.sparta.joe.util;

public class ArrayPrinter {
    //This method prints an array of type int[] to the console
    public static void arrayPrint(int[] intArray) {
        for(int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println(" ");
    }
}
