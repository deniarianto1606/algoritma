package treetraversal;

import binarysearchtree.BinarySearchTree;
import binarysearchtree.TreeNode;

/**
 * Depth First Search
 * InOrder : from left, porent, right
 * PreOrder : from parent, read left until empty, then right
 * PostOrder : from left, right, parent
 *
 */
public class DFS {
    int[] result = new int[8];
    public void preOrder(BinarySearchTree bst){
        printPreOrder(bst.root);
    }

    private void printPreOrder(TreeNode root) {
        System.out.println(root.value);
        if(root.left != null){
            printPreOrder(root.left);
        }
        if(root.right != null){
            printPreOrder(root.right);
        }
    }

    public void postOrder(BinarySearchTree bst){
        printPostOrder(bst.root);
    }

    private void printPostOrder(TreeNode root) {
        if(root.left != null){
            printPostOrder(root.left);
        }
        if(root.right != null){
            printPostOrder(root.right);
        }
        System.out.println(root.value);

    }

    /**
     *                  15
     *           7            39
     *        1     10      20      50
     */
    public void inOrder(BinarySearchTree bst){
        printInOrder(bst.root);
    }

    private void printInOrder(TreeNode root) {
        if(root.left != null){
            printInOrder(root.left);
        }
        System.out.println(root.value);
        if(root.right != null){
            printInOrder(root.right);
        }
    }
}
