package com.sparta.joe.sorters.insertionsort;

import com.sparta.joe.sorters.Sorter;

public class InsertionSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        for (int i = 1; i < arrayToSort.length; i++) {
            int key = arrayToSort[i];

            int j = i - 1;

            while(j >= 0 && arrayToSort[j] > key) {
                arrayToSort[j + 1] = arrayToSort[j];
                j--;
            }
            arrayToSort[j + 1] = key;
        }
        return arrayToSort;
    }
}
