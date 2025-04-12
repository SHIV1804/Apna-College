package BinaryTrees;

import java.util.*;

public class BinaryTrees67 {
    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node currNode = queue.remove();
            if (currNode == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
    }

    static public int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int ln = countOfNodes(root.left);
        int rn = countOfNodes(root.right);
        return ln + rn + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null)
            return 0;
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int diameterOfTreeAppreach1(Node root) {
        if (root == null)
            return 0;
        int lDiameter = diameterOfTreeAppreach1(root.left);
        int rDiameter = diameterOfTreeAppreach1(root.right);
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        return Math.max((lh + rh + 1), Math.max(rDiameter, lDiameter));
    }

    public static class info {
        int height;
        int diameter;

        public info(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static info diameterOfTreeAppreach2(Node root) {
        if (root == null)
            return new info(0, 0);
        info left = diameterOfTreeAppreach2(root.left);
        info right = diameterOfTreeAppreach2(root.right);
        int diameter = Math.max(Math.max(left.diameter, right.diameter), (left.height + right.height + 1));
        int height = Math.max(left.height, right.height) + 1;
        return new info(height, diameter);
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }else if (root == null || subRoot == null || root.data != subRoot.data) {
            return false;
        }
        //if any one node is not identical then we return false
        return isIdentical(root.left, subRoot.left) &&
        isIdentical(root.right, subRoot.right);
           
    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        } 
        //we have to only find any one node which match to subroot
        return isSubTree(root.left, subRoot)||isSubTree(root.right, subRoot);
    }

    static public class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int index = -1;

    static public class BinaryTree {

        Node buildTree(int[] nums) {
            index++;
            if (nums[index] == -1) {   
                return null;
            }
            Node newNode = new Node(nums[index]);
            newNode.left = buildTree(nums);
            newNode.right = buildTree(nums);
            return newNode;
        }

    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nums);
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        // System.out.println("Pre Order: ");
        // preOrder(root);

        // System.out.println("\nPost Order: ");
        // postOrder(root);
        // System.out.println("\nIn Order: ");
        // inOrder(root);
        // System.out.println("\nLevel order: ");
        // levelOrder(root);

        // System.out.println("Height of a tree : "+heightOfTree(root));

        // System.out.println("Count of Nodes : "+countOfNodes(root));

        // System.out.println("Sum of Nodes : "+sumOfNodes(root));

        // System.out.println("Diameter of a tree : "+diameterOfTreeApproach1(root));

        // System.out.println("Diameter of a tree :
        // "+diameterOfTreeAppreach2(root).diameter);
        
        System.out.println(isSubTree(root, subRoot));
    }

}