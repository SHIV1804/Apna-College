package LinkedList;

public class InteractionPointInLL51 {
    public static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static ListNode Head, Tail;
    public static int size;

    public static void addNode(int data) {
        ListNode newNode = new ListNode(data);
        size++;
        if (Head == null) {
            Head = Tail = newNode;
            return;
        }
        Tail.next = newNode;
        Tail = newNode;

    }
    
        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int ac = 0;
            int bc = 0;
            ListNode a = headA;
            ListNode b = headB;
            while(a != null){
                ac++;
                a = a.next;
            }
            while(b != null){
                bc++;
                b = b.next;
            }
            while(ac > bc){
                ac--;
                headA = headA.next;
            }
            while(bc > ac){
                bc--;
                headB = headB.next;
            }
            
            while(headA != headB){
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
    
    
    public static void main(String[] args) {
        ListNode headA = new ListNode(10);
        headA.next = new ListNode(30);
        headA.next.next = new ListNode(40);
        ListNode headB = new ListNode(20);
        headB.next = new ListNode(60);
        headB.next.next = new ListNode(100);
        ListNode headC = new ListNode(200);
        headC.next = new ListNode(300);
        headA.next.next.next=headC;
        headB.next.next.next=headC;
        ListNode temp = getIntersectionNode(headA, headB);
        System.out.println(temp.data);
    }
}
