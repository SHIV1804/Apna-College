package BinaryTrees;

import java.util.*;

/**
 * BinaryTrees69
 */
public class BinaryTrees69 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    boolean isValued(Node root) {
        if (root == null)
            return true;
        if (root.left != null && root.left.data != root.data) {
            return false;
        }
        if (root.right != null && root.right.data != root.data) {
            return false;
        }
        return isValued(root.left) &&
                isValued(root.right);
    }

    static void deleteLeafNode(Node root, int value) {
        if (root == null) {
            return;
        }
        deleteLeafNode(root.left, value);
        deleteLeafNode(root.right, value);

        if (root.left==null&&root.right==null) {
            root.data = -1;
        }
        if (root.left!=null&&root.left.data==-1) {
            root.left=null;
        }
        if (root.right!=null&&root.right.data==-1) {
            root.right=null;
        }
    }

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(1);
        node.left.right = new Node(1);
        node.right.right = new Node(1);
        // node.right.left = new Node(7);
        // System.out.println isValued(node));
        preOrder(node);
        deleteLeafNode(node, 1);
        System.out.println();
        preOrder(node);
    }
}
