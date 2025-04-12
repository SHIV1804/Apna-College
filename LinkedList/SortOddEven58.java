package LinkedList;

public class SortOddEven58 {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node Head, Tail;

    public static void print() {
        Node temp = Head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (Head == null) {
            Head = Tail = newNode;
            return;
        }
        Tail.next = newNode;
        Tail = newNode;
    }

    public void sort(){
        Node tempEven = Head;
        Node ttempEven = null;
        Node tempOdd = Head;
        Node ttempOdd = null;
        Node temp = Head;
        boolean isOdd = false;
        while (temp!=null) {
            
            if (temp.data%2==0){ 
                ttempEven = tempEven;
                tempEven = temp;
                
                if (isOdd) {
                    tempOdd.next=tempEven.next;
                    tempEven.next=ttempEven.next;
                    ttempEven.next=tempEven;
                    isOdd = false;
                }
            }else {
                isOdd=true;
                ttempOdd = tempOdd;
                tempOdd = temp;
            }
            temp=temp.next;
        }
        }

    public static void main(String[] args) {
        SortOddEven58 ll = new SortOddEven58();
        for (int i = 0; i < 10000; i++) {
            
            ll.addLast(i);
        }
        ll.print();
        ll.sort();
        ll.print();
    }
}
