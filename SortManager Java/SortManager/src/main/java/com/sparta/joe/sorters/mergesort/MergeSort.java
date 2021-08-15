package com.sparta.joe.sorters.mergesort;

import com.sparta.joe.sorters.Sorter;

public class MergeSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        return split(arrayToSort);
    }

    public static int[] split(int[] unsortedArray) {
        //Declare sortedArray
        int[] sortedArray;

        //Recursion Exit Condition
        if(unsortedArray.length <= 1) {
            return unsortedArray;
        }
        //Finds middle point of array for split
        int arraySplitPoint = unsortedArray.length/2;

        //Declares arrayLeft to size of array up to slit point
        //Declares arrayRight
        int[] arrayLeft = new int[arraySplitPoint];
        int[] arrayRight;

        //Initialises arrayRight, adjusting for if the un-split array is an odd number
        if(unsortedArray.length % 2 == 0) {
            arrayRight = new int[arraySplitPoint];
        } else {
            arrayRight = new int[arraySplitPoint + 1];
        }

        //Copies unsortedArray into arrayLeft and arrayRight
        for (int i = 0; i < arraySplitPoint ; i++) {
            arrayLeft[i] = unsortedArray[i];
        }
        for (int i = 0; i < arrayRight.length; i++) {
            arrayRight[i] = unsortedArray[i+arraySplitPoint];
        }

        //Recursive call for arrayLeft and arrayRight splitting
        arrayLeft = split(arrayLeft);
        arrayRight = split(arrayRight);

        sortedArray = merge(arrayLeft, arrayRight);

        return sortedArray;
    }

    private static int[] merge(int[] arrayLeft, int[] arrayRight) {

        //Declares new mergedArray to total size of arrayLeft + arrayRight
        int[] mergedArray = new int[arrayLeft.length + arrayRight.length];

        //Initialises indexes for sorting and merging array
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        //While arrayLeft or arrayRight are not empty
        while (leftIndex < arrayLeft.length || rightIndex < arrayRight.length) {
            //If both arrayLeft and arrayRight have items in
            if(leftIndex < arrayLeft.length && rightIndex < arrayRight.length) {
                //Select smaller of two at indexes and add to mergedArray
                if(arrayLeft[leftIndex] < arrayRight[rightIndex]) {
                    mergedArray[mergeIndex++] = arrayLeft[leftIndex++];
                } else {
                    mergedArray[mergeIndex++] = arrayRight[rightIndex++];
                }
            //If arrayLeft has items but arrayRight is empty, add item at leftIndex
            } else if (leftIndex < arrayLeft.length) {
                mergedArray[mergeIndex++] = arrayLeft[leftIndex++];
            //If arrayRight has items but arrayLeft is empty, add item at rightIndex
            } else if (rightIndex < arrayRight.length) {
                mergedArray[mergeIndex++] = arrayRight[rightIndex++];
            }
        }
        //Return the merged array
        return  mergedArray;
    }
}
