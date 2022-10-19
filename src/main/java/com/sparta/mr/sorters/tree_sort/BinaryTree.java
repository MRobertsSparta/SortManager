package com.sparta.mr.sorters.tree_sort;

import com.sparta.mr.exceptions.NoRootNodeException;
import com.sparta.mr.exceptions.ChildNotFoundException;

public class BinaryTree {

    private Node rootNode;

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

    public void add(int element) {
        try {
            addNode(rootNode, element);
        } catch (NoRootNodeException e) {
            rootNode = new Node(element);
        }
    }

    public void add(int... elements) {
        for (int element: elements) {
            add(element);
        }
    }

    private void addNode(Node node, int element) throws NoRootNodeException {
        if (isEmpty()) {
            throw new NoRootNodeException();
        }
        if (element < node.getElement()) {
            if (node.hasLeftNode()) {
                addNode(node.getLeftNode(), element);
            } else {
                node.setLeftNode(new Node(element));
            }
        } else if (element >= node.getElement()) {
            if (node.hasRightNode()) {
                addNode(node.getRightNode(), element);
            } else {
                node.setRightNode(new Node(element));
            }
        }
    }

    public boolean containsElement(int element) {
        try {
            findNode(element);
            return true;
        } catch (NoRootNodeException | ChildNotFoundException e) {
            return false;
        }
    }

    private Node findNode(int element) throws NoRootNodeException, ChildNotFoundException {
        if (isEmpty()) {
            throw new NoRootNodeException();
        }
        Node node = rootNode;
        while (node.hasRightNode() || node.hasLeftNode()) {
            if (element == node.getElement()) {
                return node;
            }
            if (element < node.getElement()) {
                node = node.getLeftNode();
            } else if (element > node.getElement()) {
                node = node.getRightNode();
            }
        }
        throw new ChildNotFoundException();
    }
    
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node n = findNode(element);
        return n.getLeftNode().getElement();
    }

    public int getRightChild(int element) throws ChildNotFoundException {
        Node n = findNode(element);
        return n.getRightNode().getElement();
    }

    public int getSize() {
        if (isEmpty()) {
            return 0;
        } else {
            return getSizeFromNode(rootNode);
        }
    }

    public boolean isEmpty() {
        return (rootNode == null);
    }

    private int getSizeFromNode(Node node) {
        int size = 1;
        if (node.hasRightNode()) {
            size += getSizeFromNode(node.getRightNode());
        }
        if (node.hasLeftNode()) {
            size += getSizeFromNode(node.getLeftNode());
        }
        return size;
    }

    public int[] getOrderedArray() {
        if (isEmpty()) {
            return new int[0];
        } else {
            int[] values = new int[getSize()];
            addChildElements(rootNode, values, new Index());
            return values;
        }
    }

    private void addChildElements(Node node, int[] ints, Index index) {
        if (node.hasLeftNode()) {
            addChildElements(node.getLeftNode(), ints, index);
        }
        ints[index.increment()] = node.getElement();
        if (node.hasRightNode()) {
            addChildElements(node.getRightNode(), ints, index);
        }
    }

    private class Index {
        private int value = 0;

        public int increment() {
            return value++;
        }
    }

}
