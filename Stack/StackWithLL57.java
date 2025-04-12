package Stack;

import java.util.*;


public class StackWithLL57 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node top=null;
    public static class stackWithLL{
        public static void push(int data){ 
            Node temp = new Node(data);
            if (isEmpty()) {
                top = temp;
                return;
            }
           
            temp.next = top;
            top=temp;

        }
    
    static int pop(){
        if (!isEmpty()) {
            int val = top.data;
            top = top.next;
            return val;
        }
        return Integer.MIN_VALUE;
    }
    static boolean isEmpty(){
       return top==null;
    }
    static void print(){
        Node temp = top;
        while (temp!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    static int peek(){
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return top.data;
    }
}
    public static void main(String[] args) {
        stackWithLL stack = new stackWithLL();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        stack.pop();
        stack.print();
        System.out.println(stack.peek());
    }
}