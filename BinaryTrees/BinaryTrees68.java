package BinaryTrees;

import java.util.*;

import BinaryTrees.BinaryTrees67.info;

/**
 * BinaryTrees68
 */
public class BinaryTrees68 {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        Node node;
        int horizontalDistance;

        Info(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    public static void topViewOfTree(Node root) {
        if (root == null) {
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<Info> queue = new LinkedList<Info>();
        queue.add(new Info(root, 0));
        map.put(0, root.data);
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            Info currNode = queue.remove();
            if (!map.containsKey(currNode.horizontalDistance)) {
                map.put(currNode.horizontalDistance, currNode.node.data);
                if (max < currNode.horizontalDistance) {
                    max = currNode.horizontalDistance;
                }
                if (min > currNode.horizontalDistance) {
                    min = currNode.horizontalDistance;
                }
            }
            if (currNode.node.left != null) {
                queue.add(new Info(currNode.node.left, currNode.horizontalDistance - 1));
            }
            if (currNode.node.right != null) {
                queue.add(new Info(currNode.node.right, currNode.horizontalDistance + 1));
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.println(map.get(i));
        }
    }

    public static void kthLevel(Node root, int level, int K) {
        if (root == null)
            return;
        if (K == level) {
            System.out.println(root.data);
            return;
        }
        kthLevel(root.left, level + 1, K);
        kthLevel(root.right, level + 1, K);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null)
            return false;
        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean left = getPath(root.left, n, path);
        boolean right = getPath(root.right, n, path);
        if (left || right) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static void lastCommonAncestorApproach1(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<Node>();
        ArrayList<Node> path2 = new ArrayList<Node>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        System.out.println(path1.get(i - 1).data);

    }

    public static Node lastCommonAncestorApproach2(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;
        Node left = lastCommonAncestorApproach2(root.left, n1, n2);
        Node right = lastCommonAncestorApproach2(root.right, n1, n2);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static int distance(Node root, int n) {
        if (root == null)
            return -1;
        if (root.data == n)
            return 0;
        int left = distance(root.left, n);
        int right = distance(root.right, n);
        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right + 1;
        } else {
            return left + 1;
        }
    }

   

    public static int minDistance(Node root, int n1, int n2) {
        Node lca = lastCommonAncestorApproach2(root, n1, n2);
        int distance1 = distance(lca, n1);
        int distance2 = distance(lca, n2);
        return distance1 + distance2;
    }

    public static int kthAncestor(Node root, int k, int n) {
        if (root == null)
            return -1;
        if (root.data == n)
            return 0;
        int left = kthAncestor(root.left, k, n);
        int right = kthAncestor(root.right, k, n);
        if (left == -1 && right == -1)
            return -1;
        int max = Math.max(left, right);
        if (max + 1 == k)
            System.out.println(root.data);
        return max + 1;
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }


    public static int sumTree(Node root){
        if (root==null) {
            return 0;
        }
        int left = sumTree(root.left);
        int right = sumTree(root.right);
        int data = root.data;
        int rl=0, rr=0;
       if (root.left!=null) {
             rl = root.left.data;
       }
       if (root.right!=null) {
         rr = root.right.data;
       }
        root.data = left + right + rl+rr;
        return data;

        // if (root==null) return;



        // sumTree(root.left);
        // sumTree(root.right);
        // if (root.left!=null&&root.right!=null) {
        //     root.data = root.left.data + root.right.data;
        // }else if (root.right!=null) {
        //     root.data = root.right.data;
        // } else if(root.left!=null) {
        //     root.data = root.left.data;
        // }
        // if (root.right==null&&root.left==null) {
        //     root.data = 0;
        // }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);
        // topViewOfTree(root);
        // kthLevel(root, 1, 3);
        // lastCommonAncestorApproach1(root, 5,6);
        // System.out.println(lastCommonAncestorApproach2(root, 5, 6).data);
        // System.out.println(minDistance(root, 6, 4));

        // kthAncestor(root, 2, 6);

        sumTree(root);
        preOrder(root);
    }
}