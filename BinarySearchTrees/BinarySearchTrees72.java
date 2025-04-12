
package BinarySearchTrees;

import java.util.*;

public class BinarySearchTrees72 {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class Info {
        Boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxBST = 0; 
    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0,Integer.MAX_VALUE ,Integer.MIN_VALUE );
        }
        Info leftTree = largestBST(root.left);
        Info rightTree = largestBST(root.right);
        int size = leftTree.size + rightTree.size + 1;
        int min = Math.min(Math.min(leftTree.min, rightTree.min), root.data);
        int max = Math.max(Math.max(leftTree.max, rightTree.max), root.data);
        if (leftTree.max > root.data || rightTree.min < root.data) {
            return new Info(false, size, min, max);
        }
        if (leftTree.isBST && rightTree.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);
        root.right.right.left = new Node(65);
        Info info = largestBST(root);
        System.out.println(maxBST);
        
    }

}