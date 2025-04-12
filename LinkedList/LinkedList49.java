package LinkedList;
public class LinkedList49 {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node Head;
    public static Node Tail;

    public void addNodeFirst(int data) {
        Node newNode = new Node(data);
        if (Head == null) {
            Head = newNode;
            Tail = newNode;
            return;
        }

        newNode.next = Head;
        Head = newNode;
    }
    public void addNodeLast(int data) {
        Node newNode = new Node(data);
        if (Head == null) {
            Head = newNode;
            Tail = newNode;
            return;
        }

        
        Tail.next = newNode;
        Tail=newNode;
    }
    public void addNodeMiddle(int data,int index) {
        Node newNode = new Node(data);
        if (Head == null) {
            Head = newNode;
            Tail = newNode;
            return;
        }
        Node temp = Head;
        Node ttemp=temp;
        int i=1;
        while (temp!=null&&index>i) {
            ttemp=temp;
            temp = temp.next;
            i++;
        }
        ttemp.next = newNode;
        newNode.next =temp;

    }
    public void print() {
        Node temp = Head;
        while (temp != null) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList49 ll = new LinkedList49();
        ll.addNodeFirst(1);
        ll.addNodeFirst(2);
        ll.addNodeFirst(3);
        ll.addNodeFirst(4);
        ll.print();

        ll.addNodeLast(100);
        ll.addNodeLast(1000);
        ll.print();
        ll.addNodeMiddle(10000, 4);
        ll.print();
    }
}
