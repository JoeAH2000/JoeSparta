package com.sparta.joe.sorters.binarytreesort;
import com.sparta.joe.sorters.binarytreesort.exceptions.ChildNotFoundException;

public class BinaryTreeClass implements BinaryTree {

    private int countOfNodes = 0;
    private final Node rootNode;

    private int[] sortedTree;
    private int sortCount;

    public BinaryTreeClass(int[] elements) {
        rootNode = new Node(elements[0]);
        countOfNodes++;

        for(int i = 1; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return countOfNodes;
    }

    @Override
    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
        countOfNodes++;
    }

    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            addElement(element);
        }
    }

    @Override
    public boolean findElement(final int value) {
        Node node = findNode(value);
        if (node != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        return node.getLeftChild().getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        return node.getRightChild().getValue();
    }

    @Override
    public int[] getSortedTreeAsc() {
        sortedTree = new int[countOfNodes];
        sortCount = 0;

        inOrderTraversal(rootNode);

        return sortedTree;
    }

    @Override
    public int[] getSortedTreeDesc() {
        return null;
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while (node != null) {
            if (element == node.getValue()) {
                return node;
            } else if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }

    private void addNodeToTree(Node node, int element) {
        if (element < node.getValue() || element == node.getValue()) {
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (element > node.getValue()) {
            if (node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
        return;
    }

    private void inOrderTraversal(Node currentNode) {
        if (currentNode.isLeftChildEmpty() == false) {
            inOrderTraversal(currentNode.getLeftChild());
        }

        sortedTree[sortCount++] = currentNode.getValue();

        if (currentNode.isRightChildEmpty() == false) {
            inOrderTraversal((currentNode.getRightChild()));
        }
    }

    private void reverseInOrderTraversal(Node currentNode) {
        if (currentNode.isRightChildEmpty() == false) {
            inOrderTraversal(currentNode.getRightChild());
        }

        sortedTree[sortCount++] = currentNode.getValue();

        if (currentNode.isLeftChildEmpty() == false) {
            inOrderTraversal((currentNode.getLeftChild()));
        }
    }

}