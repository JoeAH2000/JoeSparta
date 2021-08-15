package com.sparta.joe.sorters.binarytreesort;

import com.sparta.joe.sorters.Sorter;

public class BinaryTreeSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        BinaryTreeClass binaryTree = new BinaryTreeClass(arrayToSort);
        return binaryTree.getSortedTreeAsc();
    }
}
