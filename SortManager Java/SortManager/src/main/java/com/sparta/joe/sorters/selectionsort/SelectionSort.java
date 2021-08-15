package com.sparta.joe.sorters.selectionsort;

import com.sparta.joe.sorters.Sorter;

public class SelectionSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        return selectionSort(arrayToSort);
    }

    private int[] selectionSort(int[] arrayToSort) {
        for (int i = 0;  i < arrayToSort.length; i++) {
            int lowestValueIndex = i;
            for (int j = i + 1 ; j < arrayToSort.length; j++) {
                if (arrayToSort[j] < arrayToSort[lowestValueIndex]) {
                    lowestValueIndex = j;
                }
            }
            if(lowestValueIndex != i) {
                int tempSwap = arrayToSort[i];
                arrayToSort[i] = arrayToSort[lowestValueIndex];
                arrayToSort[lowestValueIndex] = tempSwap;
            }
        }
        return arrayToSort;
    }
}
