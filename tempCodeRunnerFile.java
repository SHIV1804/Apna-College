package Queue;

import java.util.*;

public class Queue63{
    class DequeJCF{
        DequeJCF(){
            Deque<Integer> deque = new ArrayDeque<Integer>();
            deque.addFirst(1);
            deque.addFirst(2);
            deque.addLast(3);
            deque.addLast(4);
            System.out.println(deque);
            System.out.println();
            System.out.println(deque.removeFirst());
            System.out.println(deque.removeLast());
            System.out.println(deque.getFirst());
        }
    }

    public static void main(String[] args){


    }
}