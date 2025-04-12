package LinkedList;

public class OperationInLL50 {

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

    // remove the first & last element

    public int removeFromHead() {
        int val = Head.data;
        size--;
        if (Head.next == null) {
            Head = Tail = null;
            return val;
        }

        Head = Head.next;
        return val;
    }

    public int removeFromTail() {
        int val = Tail.data;
        size--;
        if (Tail == Head) {
            Tail = Head = null;
            return val;
        }
        Node temp = Head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Tail = temp;
        Tail.next = null;
        return val;
    }

    // Search in a LinkedList -
    public int iterativeSearch(int key) {

        Node temp = Head;
        if (temp == null) {
            return -1;
        }
        int i = 1;
        while (temp.data != key) {
            temp = temp.next;
            i++;
        }
        if (temp.data == key) {
            System.out.println("Key found: " + temp.data);
            return i;
        }
        return -1;
    }
    //recursive search in LL
    public int findIndex(Node temp, int key) {
        if (temp == null) {
            return -1;
        }
        if (temp.data == key) {
            System.out.println("Key found: " + temp.data);
            return 1;
        }
        int position = findIndex(temp.next, key);
        if (position == -1) {
            return -1;
        }
        return position + 1;
    }

    public int recursiveSearch(int key) {
        return findIndex(Head, key);
    }


    //reversing a linked list
    public void reverse(){
        if (Head==null) {
            return;
        }
        Tail = Head;
        Node prev = null;
        Node curr = Head;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Head = prev;
        print();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Detect cycle in Ll
    public static boolean hasCycle() {
        Node slow = Head;
        Node fast = Head;
        while(fast!=null&&fast.next!=null){
            
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    //remove cycle from LL
    public static boolean removeCycle(){
        Node prev=null;
        Node slow = Head;
        Node fast = Head;
        boolean bool = false;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                bool=true;
                break;
            } 
        }
        
        if (bool) {
            slow = Head;
            
            while (fast!=slow) {
                
                prev = fast;
                fast = fast.next;
                slow = slow.next;
            }
            prev.next = null;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        OperationInLL50 ll = new OperationInLL50();
        for (int i = 1; i <= 10; i++) {
            ll.addNode(i);
        }
        
        ll.print();
        ll.removeFromHead();
        ll.removeFromTail();
        ll.print();

        System.out.println(ll.iterativeSearch(5));
        System.out.println(ll.recursiveSearch(5));

        ll.reverse();

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        
        
        Head = new Node(0);
        Head.next = head;
        head.next.next.next = Head;
        System.out.println(hasCycle());
        System.out.println(removeCycle());
        print();
    }
}
