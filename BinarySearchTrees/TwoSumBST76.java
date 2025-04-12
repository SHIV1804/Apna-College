package BinarySearchTrees;

import java.util.*;



public class TwoSumBST76 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;

        }
    }

    static public Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (data > root.data)
            root.right = insert(root.right, data);
        else
            root.left = insert(root.left, data);
        return root;
    }

    static public void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static boolean findSumBst(Node root, int val) {
        if (root == null)
            return false;
        if (root.data == val)
            return true;
        else if (root.data > val) {
            return findSumBst(root.left, val);
        } else if (root.data < val) {
            return findSumBst(root.right, val);
        }
        return false;
    }

    static int count = 0;

    static int twoSumBst(Node root1, Node root2, int val) {
        if (root1 == null)
            return 0;
        twoSumBst(root1.left, root2, val);
        int subtract = val - root1.data;
        if (findSumBst(root2, subtract)) {
            count++;
        }
        twoSumBst(root1.right, root2, val);
        return count;
    }

    // static boolean validBst(Node root) {
    //     if (root == null)
    //         return true;
    //     if (root.left != null && root.data < root.left.data)
    //         return false;
    //     if (root.right != null && root.data > root.right.data)
    //         return false;
    //     return validBst(root.left) &&
    //             validBst(root.right);
    // }

    static int maxValue(Node root){
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(Math.max(maxValue(root.left),maxValue(root.right)), root.data);
    }

    static int minValue(Node root){
        if(root==null) return Integer.MAX_VALUE;
        return Math.min(Math.min(minValue(root.left),minValue(root.right)), root.data);
    }
    static boolean validBst(Node root) {
        if (root == null)
            return true;
        int left = maxValue(root.left);
        int right = minValue(root.right);
        return (left>root.data||right<root.data)?false:true;
    }

    int maxSum =0;

    int maxSumBst(Node root){
        if(root==null) return 0;
        
        maxSumBst(root.left);
        if(validBst(root)){
            maxSum = Math.max(maxSum,sumOfNodes(root));
        }
        maxSumBst(root.right);
        return maxSum;
    }
   
    int sumOfNodes(Node node) {
        if(node == null) return 0;
        return sumOfNodes(node.left)+sumOfNodes(node.right)+node.data;
    }

    public static void main(String[] args) {
        TwoSumBST76 temp = new TwoSumBST76();
        Node root1 = null;
        Node root2 = null;
        int[] nums1 = { 5, 3, 2, 4, 7, 6, 8 };
        int[] nums2 = { 10, 6, 3, 8, 15, 11, 18 };
        for (int i = 0; i < nums1.length; i++) {
            root1 = insert(root1, nums1[i]);
        }
        
        inOrder(root1);
        System.out.println();
        for (int i = 0; i < nums2.length; i++) {
            root2 = insert(root2, nums2[i]);
        }
        
        inOrder(root2);
        System.out.println();
        System.out.println(twoSumBst(root1, root2, 16));

        System.out.println(temp.maxSumBst(root1));
        
        
        
    }

}