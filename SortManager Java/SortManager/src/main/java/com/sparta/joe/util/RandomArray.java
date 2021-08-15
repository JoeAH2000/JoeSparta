package com.sparta.joe.util;

public class RandomArray {
    // This method produces a random array of type int[], which contains arrayLength values of between lowerBound and upperBound inclusive
    public static int[] randomIntArray(int arrayLength, int lowerBound, int upperBound) {
        int[] randomArray = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = (int)Math.floor(Math.random() * (upperBound - lowerBound + 1) + lowerBound);
        }
        return randomArray;
    }
}
