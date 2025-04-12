package BinarySearchTrees;
import java.util.*;

class BinarySearchTrees73{

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root,ArrayList<Node> nodes){
        if(root == null) return;
        inOrder(root.left,nodes);
        nodes.add(root);
        inOrder(root.right,nodes);
    }
    public static Node createBST(ArrayList<Node> nodes,int start,int end) {
        if(start>end) return null;
        int mid = (start+end) / 2;
        Node root = nodes.get(mid);
        root.left = createBST(nodes, start, mid-1);
        root.right = createBST(nodes,mid+1, end);
        return root;
    }
    public static void merge(Node left, Node right){
        ArrayList<Node> temp1 = new ArrayList<Node>();
        ArrayList<Node> temp2 = new ArrayList<Node>();
         inOrder(left, temp1);
         inOrder(right,temp2);
        int i=0,j=0;
        ArrayList<Node> tempFinal = new ArrayList<Node>();
        while (i<temp1.size()&&j<temp2.size()) {
            if (temp1.get(i).data<=temp2.get(j).data) {
                tempFinal.add(temp1.get(i++));
            }else{
                tempFinal.add(temp2.get(j++)) ;
            }
        }
        while (i<temp1.size()) {
            tempFinal.add(temp1.get(i++));
        }
        while (j<temp2.size()) {
            tempFinal.add(temp2.get(j++)) ;
        }
        Node root = createBST(tempFinal, 0, tempFinal.size()-1);
        preOrder(root);
    }

    public static void main(String[] args){
        Node root1 = new Node(4);
        root1.left = new Node(2);
        root1.right = new Node(9);
        
        System.out.println();
        Node root2 = new Node(3);
        root2.left = new Node(1);
        root2.right = new Node(12);
       
        System.out.println();
         merge(root1, root2);
        
    }
}