package LinkedList;

public class ZigZagLL52 {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node Head, Tail;
    public static int size;

    public void addNode(int data) {
        Node newNode = new Node(data);
        size++;
        if (Head == null) {
            Head = Tail = newNode;
            return;
        }
        Tail.next = newNode;
        Tail = newNode;

    }

    public static void print() {
        Node temp = Head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    
    public static void zigZagLL(){
        Node slow = Head;
        Node fast = Head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        Node prev = null;
        Node curr =  mid.next;
        Node next;
        mid.next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = Head;
        Node right = prev;
        Node nextL;
        Node nextR;
        while (left != null&&right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
        
        
       
        
    }

    public static void main(String[] args) {
        Head = new Node(1);
        Head.next = new Node(2);
        Head.next.next = new Node(3);
        Head.next.next.next = new Node(4);
        Head.next.next.next.next = new Node(5);
        print();
        zigZagLL();
        print();
    }
}
