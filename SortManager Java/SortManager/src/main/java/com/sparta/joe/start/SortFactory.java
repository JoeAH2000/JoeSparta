package com.sparta.joe.start;

import com.sparta.joe.sorters.Sorter;
import com.sparta.joe.sorters.binarytreesort.BinaryTreeSort;
import com.sparta.joe.sorters.bubblesort.BubbleSort;
import com.sparta.joe.sorters.insertionsort.InsertionSort;
import com.sparta.joe.sorters.mergesort.MergeSort;
import com.sparta.joe.sorters.quicksort.QuickSort;
import com.sparta.joe.sorters.selectionsort.SelectionSort;

public class SortFactory {
    public static Sorter getSorter(int sortSelected, int[] unsortedArray) {

        if (sortSelected == 1) {
            return new BubbleSort();
        } else if (sortSelected == 2) {
            return new InsertionSort();
        } else if (sortSelected == 3) {
            return new MergeSort();
        } else if (sortSelected == 4) {
            return new QuickSort();
        } else if (sortSelected == 5) {
            return new SelectionSort();
        } else if (sortSelected == 6) {
            return new BinaryTreeSort();
        } else {
            return null;
        }
    }
}
