package treetraversal;

import binarysearchtree.BinarySearchTree;
import org.junit.jupiter.api.Test;

public class BFSTest {

    /**
     *                  15
     *           7            39
     *        1     10      20      50
     */
    @Test
    public void bfs_test(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(15);
        bst.add(39);
        bst.add(7);
        bst.add(1);
        bst.add(10);
        bst.add(20);
        bst.add(50);
        bst.add(60);
        BFS bfs = new BFS();
        bfs.bfs(bst);
    }

    @Test
    public void bst_test_return(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(15);
        bst.add(39);
        bst.add(7);
        bst.add(1);
        bst.add(10);
        bst.add(20);
        bst.add(50);
        bst.add(60);
        BFS bfs = new BFS();
        int[] result = bfs.printReqursiveReturnValue(bst);
        System.out.println(result);
    }
}
