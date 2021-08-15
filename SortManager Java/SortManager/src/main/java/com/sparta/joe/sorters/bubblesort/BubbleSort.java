package com.sparta.joe.sorters.bubblesort;

import com.sparta.joe.sorters.Sorter;

public class BubbleSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        return bubbleSort(arrayToSort);
    }

    private int[] bubbleSort(int[] arrayToSort) {
        int sorted = 0;
        for (int i = 0; i < arrayToSort.length; i++) {
            int currentPos = 0;
            while (currentPos < (arrayToSort.length - (1 + sorted))) {
                if (arrayToSort[currentPos] > arrayToSort[currentPos + 1]) {
                    int tempNumber = arrayToSort[currentPos + 1];
                    arrayToSort[currentPos + 1] = arrayToSort[currentPos];
                    arrayToSort[currentPos] = tempNumber;
                }
                currentPos = currentPos + 1;
            }
            sorted++;
        }
        return arrayToSort;
    }
}
