package ArrayList;

public class StackLinkedList56 {
    public static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static class Stack{
        Node head = null;
        boolean isEmpty(){
            return head == null;
        }
        void push(int data){
            Node temp = new Node(data);
            if (isEmpty()) {
                head = temp;
                return;
            }
           temp.next = head;
           head = temp;
        }
        int peek(){
            return head.data;
        }
    }

    public static void main(String[] args) {
        SortLinkedList56 s = new SortLinkedList();

    }
}
