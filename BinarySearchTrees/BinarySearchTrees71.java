package BinarySearchTrees;

import java.util.*;

public class BinarySearchTrees71 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        }
        if (root.data < data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    static Node deleteNode(Node root, int data) {
        if (root == null)
            return null;
        if (root.data > data) {
            root.left = deleteNode(root.left, data);
        } else if (root.data < data) {
            root.right = deleteNode(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node inOrderSuccessor = inOrderSuccessor(root.right);
            root = inOrderSuccessor;
            root.right = deleteNode(root.right, inOrderSuccessor.data);

        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null)
            return;
        if (root.data <= k2 && root.data >= k1) {

            printInRange(root.left, k1, k2);
            System.out.println(root.data);
            printInRange(root.right, k1, k2);

        } else if (root.data > k2) {
            printInRange(root.left, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        }

    }

    public static void printPath(ArrayList<Integer> nums) {
        for (int j = 0; j < nums.size(); j++) {
            System.out.print(nums.get(j) + "->");
        }
        System.out.print("null\n");
    }

    public static void printleafPath(Node root, ArrayList<Integer> nums) {
        if (root == null)
            return;
        nums.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(nums);
        }
        printleafPath(root.left, nums);
        printleafPath(root.right, nums);
        nums.remove(nums.size() - 1);
    }

    public static boolean isValidBSTApproach1(Node root, int min, int max) {
        if (root == null)
            return true;
        if (!(min <= root.data && root.data <= max))
            return false;
        return isValidBSTApproach1(root.left, min, root.data) &&
                isValidBSTApproach1(root.right, root.data, max);
    }

    public static Node mirrorBST(Node root) {
        if (root == null)
            return null;
        Node leftMirror = mirrorBST(root.left);
        Node rightMirror = mirrorBST(root.right);
        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static Node creatingBalancedBST(int start,int end,int[] nums){
        if(start>end) return null;
        int mid = (start + end)/2;
        Node root = new Node(nums[mid]);
        root.left = creatingBalancedBST( start, mid-1, nums);
        root.right = creatingBalancedBST( mid+1, end,nums);
        return root;
    }

    public static void inOrder(Node root,ArrayList<Node> nums){
        if (root == null) {
            return;
        }
        inOrder(root.left);
        nums.add(root);
        inOrder(root.right);
    }

    public static Node creatingBalancedBST(ArrayList<Node> nums,int start,int end){
        if(start>end) return null;
        int mid = (start + end) / 2;
        Node root = nums.get(mid);
        root.left=creatingBalancedBST(nums, start, mid-1);
        root.right=creatingBalancedBST(nums, mid+1, end);
        return root;
    }

    public static Node unbalancedToBalancedBST(Node root){
        ArrayList<Node> nums = new ArrayList<Node>();
        inOrder(root, nums);
        return creatingBalancedBST(nums,0,nums.size());
    }

    public static void main(String[] args) {
        Node root = null;
        // int[] nums = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        // for (int i = 0; i < nums.length; i++) {
        // root = insert(root, nums[i]);
        // }
        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);
        // inOrder(root);
        // System.out.println();
        // deleteNode(root, 7);
        // System.out.println();
        // inOrder(root);
        // System.out.println();
        // printInRange(root, 5, 10);

        // printleafPath(root, new ArrayList<>());

        // System.out.println(isValidBSTApproach1(root, Integer.MIN_VALUE,
        // Integer.MAX_VALUE));

        // preOrder(root);
        // System.out.println();
        // root = mirrorBST(root);
        // preOrder(root);
        
        // root = creatingBalancedBST( 0, 11, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        // preOrder(root);

    }
}