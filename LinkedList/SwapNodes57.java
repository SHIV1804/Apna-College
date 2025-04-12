package LinkedList;

public class SwapNodes57 {
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

    public static void swapNodes(int x, int y) {
        if (x == y) {
            return;
        }
        Node tempX = null;
        Node tempY = null;
        Node ttempx = Head;
        Node ttempy = Head;
        while (ttempx.data != x) {
            tempX = ttempx;
            ttempx = ttempx.next;
        }
        
        while (ttempy.data != y) {

            tempY = ttempy;
            ttempy = ttempy.next;
        }
        

        if (ttempx == null || ttempy == null) {
            return;
        }
        if (tempX != null) {
            tempX.next = ttempy;
        } else Head = ttempy;
        
        if (tempY != null) {
            tempY.next = ttempx;
        } else {
            Head = ttempx;
        }
        Node tttNode = ttempy.next;
        ttempy.next = ttempx.next;
        ttempx.next = tttNode;

    }

    public static void main(String[] args) {
        SwapNodes57 ll = new SwapNodes57();
        for (int i = 0; i < 10; i++) {
            ll.addLast(i);
        }
        ll.print();
        ll.swapNodes(0, 9);

        ll.print();
    }
}
