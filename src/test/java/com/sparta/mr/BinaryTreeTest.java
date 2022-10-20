package com.sparta.mr;

import com.sparta.mr.controller.exceptions.ChildNotFoundException;
import com.sparta.mr.model.sorters.tree_sort.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BinaryTreeTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Test that an element added to the tree can then be found")
    public void testElementCanBeFound(int element) {
        BinaryTree tree = new BinaryTree();
        tree.add(element);
        Assertions.assertTrue(tree.containsElement(element));
    }

    @Test
    @DisplayName("Test that an element not added to the tree cannot be found")
    public void testElementCannotBeFound() {
        BinaryTree tree = new BinaryTree();
        Assertions.assertFalse(tree.containsElement(1));
    }

    @Test
    @DisplayName("Test that elements are placed in the correct place in the tree")
    public void testElementsArePlacedCorrectly() {
        BinaryTree tree = new BinaryTree();
        tree.add(2, 1, 3);
        Assertions.assertEquals(1, tree.getLeftChild(2));
        Assertions.assertEquals(3, tree.getRightChild(2));
    }

    @Test
    @DisplayName("Test if an element that doesn't have a right child throws an exception if asked for it's right child")
    public void testAbsentRightChildThrowsException() {
        BinaryTree tree = new BinaryTree();
        tree.add(2, 1);
        Assertions.assertThrows(ChildNotFoundException.class, () -> tree.getRightChild(2));
    }

    @Test
    @DisplayName("Test if an element that doesn't have a left child throws an exception if asked for it's left child")
    public void testAbsentLeftChildThrowsException() {
        BinaryTree tree = new BinaryTree();
        tree.add(2, 3);
        Assertions.assertThrows(ChildNotFoundException.class, () -> tree.getLeftChild(2));
    }

    @Test
    @DisplayName("Test that the tree returns the correct size")
    public void testGetSize() {
        BinaryTree tree = new BinaryTree();
        tree.add(2, 1, 3);
        Assertions.assertEquals(3, tree.getSize());
    }

    @Test
    @DisplayName("Test that an empty tree returns a size of 0")
    public void testEmptyTreeGetSize() {
        BinaryTree tree = new BinaryTree();
        Assertions.assertEquals(0, tree.getSize());
    }

    @Test
    @DisplayName("Test that an empty tree returns true when asked if it's empty")
    public void testIsEmpty() {
        BinaryTree tree = new BinaryTree();
        Assertions.assertTrue(tree.isEmpty());
    }

    @Test
    @DisplayName("Test that a tree that isn't empty returns false when asked if it's empty")
    public void testNotEmpty() {
        BinaryTree tree = new BinaryTree();
        tree.add(1, 2, 3);
        Assertions.assertFalse(tree.isEmpty());
    }
}
