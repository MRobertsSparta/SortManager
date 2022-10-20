package com.sparta.mr.model.sorters.tree_sort;

import com.sparta.mr.controller.logging.CustomLogger;
import com.sparta.mr.controller.exceptions.NoRootNodeException;
import com.sparta.mr.controller.exceptions.ChildNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryTree {

    private static final Logger logger = CustomLogger.getLogger();
    private Node rootNode;

    private class Node {

        private final int element;
        private Node leftNode;
        private Node rightNode;

        public Node(int element) {
            this.element = element;
            logger.log(Level.FINEST, "Node created with element value of " + element);
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

    private class Index {
        private int value = 0;

        public int increment() {
            logger.log(Level.FINEST, "Index object incremented");
            return value++;
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
            logger.log(Level.FINER, "Searching for element with value " + element);
            findNode(element);
            return true;
        } catch (NoRootNodeException | ChildNotFoundException e) {
            logger.log(Level.FINER, "Element could not be found.");
            return false;
        }
    }

    private Node findNode(int element) throws NoRootNodeException, ChildNotFoundException {
        if (isEmpty()) {
            throw new NoRootNodeException();
        }
        Node node = rootNode;
        do {
            if (element == node.getElement()) {
                logger.log(Level.FINER, "Found element with value of " + element);
                return node;
            }
            if (element < node.getElement()) {
                logger.log(Level.FINEST, "Searched node has element with value of "
                        + node.getElement() + ", searching left child.");
                node = node.getLeftNode();
            } else if (element > node.getElement()) {
                node = node.getRightNode();
                logger.log(Level.FINEST, "Searched node has element with value of "
                        + node.getElement() + ", searching right child.");
            }
        } while (node.hasRightNode() || node.hasLeftNode());
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
        logger.log(Level.FINEST, "Tree size requested.");
        if (isEmpty()) {
            logger.log(Level.FINEST, "Tree is empty");
            return 0;
        } else {
            int size = getSizeFromNode(rootNode);
            logger.log(Level.FINEST, "Tree has size of " + size);
            return size;
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
        logger.log(Level.FINE, "Ordered array requested from binary tree");
        if (isEmpty()) {
            logger.log(Level.FINER, "Binary tree is empty, empty array returned");
            return new int[0];
        } else {
            int[] values = new int[getSize()];
            logger.log(Level.FINER, "Created array with length " + values.length);
            addChildElements(rootNode, values, new Index());
            return values;
        }
    }

    private void addChildElements(Node node, int[] ints, Index index) {
        logger.log(Level.FINER, "Moved to node with element " + node.getElement());
        if (node.hasLeftNode()) {
            logger.log(Level.FINEST, "Node has left child, moving to left child.");
            addChildElements(node.getLeftNode(), ints, index);
        }
        logger.log(Level.FINER, "Added element " + node.getElement() + " at index " + index.value);
        ints[index.increment()] = node.getElement();
        if (node.hasRightNode()) {
            logger.log(Level.FINEST, "Node has right child, moving to right child.");
            addChildElements(node.getRightNode(), ints, index);
        }
        logger.log(Level.FINEST, "Moved to parent node.");
    }

}
