package BinaryTrees;

import java.util.*;

public class BinarySearchTrees70 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data >= data)
            root.left = insert(root.left, data);
        if (root.data < data)
            root.right = insert(root.right, data);
        return root;
    }
    static Node search(Node root,int data){
        if (root==null) {
            return null;
        }
        if (root.data==data) {
            return root;
        }
        if (root.data>data) {
            return search(root.left, data);
        }
        if (root.data<data) {
            return search(root.right, data);
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = null;
        for (int i = 0; i < 10; i++) {
            root=insert(root, i);
        }
        inOrder(root);
        System.out.println();
        System.out.println(search(root, 9)!=null?search(root, 9).data:null);
    }
}
