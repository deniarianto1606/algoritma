package binarysearchtree;

/**
 * Binary Search Tree
 * List - linear
 * Trees - non linear
 * edge - connection to a node and another
 * leaf - a node with no children
 * only have 2 nodes children
 * left always less than right and the parent
 * Insertion - O(log n)
 * Searching - O(log n)
 * will become n when value is always greater or smaller
 * example 1,2,3,4,5,6,7,8,9
 */
public class BinarySearchTree {

    public TreeNode root;

    public void add(int value, TreeNode root){
        TreeNode newNode = new TreeNode(value, null, null);

        if(value < root.value){
            if(root.left == null){
                root.left = newNode;
                return;
            }else{
                add(value, root.left);
            }
        }
        else{
            if(root.right == null){
                root.right = newNode;
                return;
            }else{
                add(value, root.right);
            }
        }

    }

    public void add(int value){
        if(root == null){
            root = new TreeNode(value, null, null);
            return;
        }
        add(value, root);
    }

    public void find(int value){
        if(root == null){
            System.out.println("value not found");
        }

        find(value, root);
    }

    private void find(int value, TreeNode root) {
        //base case
        if(value == root.value){
            System.out.println("value is found");
            return;
        }else if(value < root.value){
            if(root.left == null){
                System.out.println("value not found");
                return;
            }
            find(value, root.left);
        }else {
            if(root.right == null){
                System.out.println("value not found");
                return;
            }
            find(value, root.right);
        }
    }
}
