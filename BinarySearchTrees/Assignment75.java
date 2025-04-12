package BinarySearchTrees;

import java.util.*;

public class Assignment75 {
    static class Node {
        int data;
        Node right, left;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;

        }
    }
    public static void inOrder(Node root){
        if (root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void preOrder(Node root){
        if (root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }



    public static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (root.data > data)
            root.left = insert(root.left, data);
        else if (root.data < data)
            root.right = insert(root.right, data);

        return root;

    }

    public static int rangeSum(Node root,int min,int max){
        if(root == null) return 0;
        int sum =0;
        if (root.data>=min&&root.data<=max){
            sum+=root.data;
        }
        sum +=rangeSum(root.left, min, max)+rangeSum(root.right, min, max);
        return sum;
    }
    static int min=Integer.MAX_VALUE;
    public static int absoluteDifference(Node root,int val){
        if(root==null) return Integer.MAX_VALUE;
        if (Math.abs(root.data-val)<Math.abs(min-val)) {
            min=root.data;
        }
        if (root.data>val) {
            absoluteDifference(root.left, val);
        }else if(root.data<val){
            absoluteDifference(root.right, val);
        }
        return min;
    }
    static int count=0;
    public static void findKthSmallest(Node root,int k){
        if (root==null) {
            return;
        }
        
        findKthSmallest(root.right,k);
        if(root!=null) count++;
        if(k==count) { 
            System.out.println(root.data);
            return;
        }
        findKthSmallest(root.left,k);
       
        
    }


    public static void main(String[] args) {
        Node root=null;
        int nums[]=new int[1000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)Math.floor(Math.random()*1000);
        }
        for (int i = 0; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }
        
        preOrder(root);
        System.out.println();
        System.out.println(rangeSum(root, 1, 3));
        System.out.println();
        System.out.println(absoluteDifference(root, 19));

        System.out.println();
        inOrder(root);
        System.out.println();
        findKthSmallest(root,100);
    }
}