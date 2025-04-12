package LinkedList;

public class DoublyLL53 {
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static Node Head,Tail;
    public static void print(){
        Node temp = Head;
        while (temp != null) {
            System.out.print(temp.data+" <-> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if (Head==null) {
            Head = Tail = newNode;
        }
        newNode.next = Head;
        newNode.prev = null;
        Head.prev = newNode;
        Head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if (Head==null) {
            Head = Tail = newNode;
        }
        newNode.next = null;
        newNode.prev = Tail;
        Tail.next = newNode;
        Tail = newNode;
    }
    public int removeFirst(){
        int val = Head.data;
        if (Head.next == null) {
            Head = Tail =null;
            return val;
        }
       
        Node temp = Head.next;
        temp.prev = null;
        Head.next = null;
        Head = temp;
        return val;
    }
    public int removeLast(){
        int val = Tail.data;
        if (Head == Tail) {
            Head = Tail = null;
            return val;
        }
        Node temp = Head;
        Node ttemp=temp;
        while (temp.next != null) {
            ttemp = temp;
            temp = temp.next;
        }
        ttemp.next = null;
        temp.prev = null;
        Tail = ttemp;
        return val;
    }
    public void reverse(){
        Node curr = Head;
        Tail = Head;
        Node prev = null;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        Head = prev;
        
    }
    public static void main(String[] args) {
        DoublyLL53 ll = new DoublyLL53();
        ll.addFirst(0);
        ll.addLast(1);
        ll.addFirst(2);
        ll.addFirst(3);
        print();
        ll.reverse();
        print();
        
        ll.removeLast();
        print();
        ll.removeFirst();
        print();
    }
}
