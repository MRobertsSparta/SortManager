package com.sparta.mr.sorters.binary_tree;

import com.sparta.mr.exceptions.ChildNotFoundException;

public class Node {

    private final int element;
    private Node leftNode;
    private Node rightNode;

    public Node(int element) {
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public Node getLeftNode() throws ChildNotFoundException {
        if (leftNode == null) {
            throw new ChildNotFoundException();
        }
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() throws ChildNotFoundException {
        if (rightNode == null) {
            throw new ChildNotFoundException();
        }
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public boolean hasLeftNode() {
        return (leftNode != null);
    }

    public boolean hasRightNode() {
        return (rightNode != null);
    }
}
