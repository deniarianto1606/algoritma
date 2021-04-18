package treetraversal;

import binarysearchtree.BinarySearchTree;
import org.junit.jupiter.api.Test;

public class DFSTest {

    /**
     *                  15
     *           7            39
     *        1     10      20      50
     *                                  60
     */
    @Test
    public void dfs_preOrder(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(15);
        bst.add(39);
        bst.add(7);
        bst.add(1);
        bst.add(10);
        bst.add(20);
        bst.add(50);
        bst.add(60);
        DFS bfs = new DFS();
        bfs.preOrder(bst);
    }

    @Test
    public void dfs_postOrder(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(15);
        bst.add(39);
        bst.add(7);
        bst.add(1);
        bst.add(10);
        bst.add(20);
        bst.add(50);
        bst.add(60);
        DFS bfs = new DFS();
        bfs.postOrder(bst);
    }

    @Test
    public void dfs_inOrder(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(15);
        bst.add(39);
        bst.add(7);
        bst.add(1);
        bst.add(10);
        bst.add(20);
        bst.add(50);
        bst.add(60);
        DFS bfs = new DFS();
        bfs.inOrder(bst);
    }
}
