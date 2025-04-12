package LinkedList;

public class MNNodes54 {
    class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node Head,Tail;
    public static void print(){
        Node temp = Head;
        while (temp != null) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if (Head == null) {
            Head = Tail = newNode;
            return;
        }
        Tail.next = newNode;
        Tail = newNode;
    }
    public void mnNodes(int m,int n){
        Node temp = Head;
        for (int i = 0; i < m-1; i++) {
            temp = temp.next;
        }
        Node ttemp = temp;
        for (int i = 0; i < n; i++) {
            ttemp = ttemp.next;
        }
        if (ttemp.next==null) {
            Tail = temp;
        }

        temp.next = ttemp.next;
        ttemp.next = null;
        
    }
    public static void main(String[] args) {
        MNNodes54 ll = new MNNodes54();
        for (int i = 0; i < 10; i++) {
            ll.addLast(i);
        }
        ll.mnNodes(2, 4);
        ll.print();
    }
}
