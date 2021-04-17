package binarysearchtree;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void BST_add(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(15);
        bst.add(39);
        bst.add(7);
        bst.add(1);
        bst.add(10);
        bst.add(20);
        bst.add(50);
        bst.find(20);
        System.out.println(bst);
    }
}
