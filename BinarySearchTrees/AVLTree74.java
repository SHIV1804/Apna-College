package BinarySearchTrees;

import java.util.*;



public class AVLTree74{
    public static class Node{
        int data, height;
        Node left,right;

        Node(int data){
            this.data = data;
            this.height =1;
        }
    }
    public static int height(Node root){
        if (root==null) return 0;
        return root.height;
    }
    
    public static int balancedFactor(Node root){
        if (root==null) return 0;
        return (height(root.left)-height(root.right));
    }
    public static Node leftRotation(Node p){
        Node q = p.right;
        Node t = q.left;
        q.left = p;
        p.right = t;
        p.height =Math.max(height(p.left),height(p.right))+1;
        q.height = Math.max(height(q.left),height(q.right))+1;
        return q;
    }
    public static Node rightRotation(Node p){
        Node q = p.left;
        Node t = q.right;
        q.right = p;
        p.left = t;
        p.height = height(p.left)+height(p.right);
        q.height = height(q.left)+height(q.right);
        return q;
    }
    public static Node insert(Node root,int key){
        if (root==null) {
            return new Node(key);
        }
        if (key<root.data) {
            root.left= insert(root.left, key);
        }else if (key>root.data) {
            root.right= insert(root.right, key);
        }
        root.height = Math.max(height(root.left), height(root.right))+1;
        int balancedFactor= balancedFactor(root);
        //LL Case
        if (balancedFactor>1&&key<root.left.data) {
            return rightRotation(root);
        }
        //RR Case
        if (balancedFactor<-1&&key>root.right.data) {
            return leftRotation(root);
        }
        //LR Case
        if (balancedFactor>1&&key>root.left.data) {
            root.left=leftRotation(root.left);
            return rightRotation(root);
        }
        //RL Case
        if (balancedFactor<-1&&key< root.right.data) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        return root;
    }
    public static void preOrder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node root;
    public static void main(String[] args) {
       
        for (int i = 0; i < 10; i++) {
            root = insert(root, i);
        }
    // root = insert(root,40);
    // root = insert(root,20);
    // root = insert(root,10); 
    // root = insert(root,25);
    // root = insert(root,30);
    // root = insert(root,22);
    // root = insert(root,50);
    preOrder(root);
    }
}