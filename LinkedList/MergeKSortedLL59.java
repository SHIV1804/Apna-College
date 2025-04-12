package LinkedList;

public class MergeKSortedLL59 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
        // public static Node Head, Tail;
        // public void addLast(int data) {
        //     Node newNode = new Node(data);
        //     if (Head == null) {
        //         Head = Tail = newNode;
        //         return;
        //     }
        //     Tail.next = newNode;
        //     Tail = newNode;
        // }

        

        public void print(Node temp) {
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.print("null");
            System.out.println();
        }
    }

    public static Node merge(Node left, Node right) {
        Node temp = new Node(-1);
        Node tempHead = temp;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            } else {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        while (left != null) {
            temp.next = left;
            temp = temp.next;
            left = left.next;
        }
        while (right != null) {
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }
        return tempHead.next;
    }
    public static void mergeN(Node[]nodes) {
        Node temp=null;
        for (int i = 0; i < nodes.length; i++) {
            temp=merge(temp,nodes[i]);
        }
        temp.print(temp);
    }
    
    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node head2 = new Node(0);
        Node tempHead1 = head1;
        Node tempHead2 = head2;
        tempHead1.next = new Node(4);
        tempHead1.next.next = new Node(8);
        tempHead2.next = new Node(3);
        tempHead2.next.next = new Node(5);
        Node head3 = new Node(2);
        Node tempHead3 = head3;
        
        tempHead3.next = new Node(6);
        tempHead3.next.next = new Node(7);
        // for (int i = 2; i < 10; i++) {
        //     if (i % 2 == 0){
        //         head2=head2.next;
        //     head2 = new Node(i);}
        // }
        tempHead2.print(tempHead2);
        // for (int i = 3; i < 10; i++) {
        //     if (i % 2 != 0){
        //     head1=head1.next;
        //     head1 = new Node(i);
        // }}
        tempHead1.print(tempHead1);
        
        // Node temp = merge(tempHead1, tempHead2);
        
        // temp.print(temp);
        tempHead3.print(tempHead3);
        Node[] nums={tempHead1, tempHead2, tempHead3};
        mergeN(nums);
        
    }
}
