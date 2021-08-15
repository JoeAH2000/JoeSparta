package com.sparta.joe.sorters.binarytreesort;

//import com.sparta.kwd.starter.exceptions.ChildNotFoundException;

import com.sparta.joe.sorters.binarytreesort.exceptions.ChildNotFoundException;

public interface BinaryTree {
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}
