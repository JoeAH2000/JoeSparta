package com.sparta.joe.sorters.quicksort;

import com.sparta.joe.sorters.Sorter;

public class QuickSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        quickSort(arrayToSort, 0, arrayToSort.length-1);
        return arrayToSort;
    }

    private void quickSort(int[] arrayToSort, int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            int pivotIndex = sortPartition(arrayToSort, lowerBound, upperBound);
            quickSort(arrayToSort, lowerBound, pivotIndex - 1);
            quickSort(arrayToSort, pivotIndex + 1, upperBound);
        }
    }

    private int sortPartition(int [] arrayToSort, int lowerBound, int upperBound) {
        int pivotValue = arrayToSort[upperBound];

        int pointer = lowerBound - 1;

        for (int i = lowerBound; i <= upperBound - 1; i++) {
            if (arrayToSort[i] < pivotValue) {
                arraySwap(arrayToSort, ++pointer, i);
            }
        }
        arraySwap(arrayToSort, pointer + 1, upperBound);
        return pointer+1;
    }

    private void arraySwap(int[] arrayToSort, int num1Index, int num2Index) {
        int tempNum = arrayToSort[num1Index];
        arrayToSort[num1Index] = arrayToSort[num2Index];
        arrayToSort[num2Index] = tempNum;
    }
}
