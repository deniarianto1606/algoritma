package treetraversal;

import binarysearchtree.BinarySearchTree;
import binarysearchtree.TreeNode;

/**
 * Breadth First Search
 * start from begining and read from left to right
 *
 */
public class BFS {

    private int[] result= new int[8];
    private int index = 0;

    public void bfs(BinarySearchTree bst){
        System.out.println(bst.root.value);
        printRecursive(bst.root);
    }

    private void printRecursive(TreeNode node) {
        if(node.left != null){
            System.out.println(node.left.value);
        }
        if(node.right != null){
            System.out.println(node.right.value);
        }
        if(node.left != null){
            printRecursive(node.left);
        }
        if(node.right != null){
            printRecursive(node.right);
        }
    }

    public int[] printReqursiveReturnValue(BinarySearchTree bst){
        result[index++] = bst.root.value;
        printReqursiveReturnValue(bst.root);
        return result;
    }

    private void printReqursiveReturnValue(TreeNode node){
        if(node.left != null){
            result[index++] = node.left.value;
        }
        if(node.right != null){
            result[index++] = node.right.value;
        }
        if(node.left != null){
            printReqursiveReturnValue(node.left);
        }
        if(node.right != null){
            printReqursiveReturnValue(node.right);
        }
    }
}
