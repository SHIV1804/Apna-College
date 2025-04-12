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

    class StackDeque <T>{
        Deque <T> deque = new ArrayDeque<T>();
        boolean isEmpty(){
            return deque.isEmpty();
        }
        void push(T item){
            deque.addLast(item);
        }
        T pop(){
            return deque.removeLast();
        }
        T peek(){
            return deque.getLast();
        }
    }

    class QueueDeque <T>{
        Deque <T> deque = new ArrayDeque<T>();
        boolean isEmpty(){
            return deque.isEmpty();
        }
        void enqueue(T item){
            deque.addLast(item);
        }
        T dequeue(){
            return deque.removeFirst();
        }
        T peek(){
            return deque.getFirst();
        }
    }

    static void generateBinaryNumbersDeque(int length){
        Deque<Integer> Deque = new ArrayDeque<Integer>();
        for (int i = 1; i <= length; i++) {
            int temp=i;
            while (temp!=0) {
                Deque.addFirst(temp%2);
                temp=temp/2;
            }
           while (!Deque.isEmpty()) {
                System.out.print(Deque.removeFirst());
           }
            System.out.println();
        }
    }

    static void generateBinaryNumbersQueue(int length){
        Queue<String> queue = new ArrayDeque<String>();
        String s1;
        queue.add("1");
        for (int i = 1; i <= length; i++) {
            s1 = queue.peek();
            queue.remove();
            System.out.println(s1);
            String s2 = s1;
            queue.add(s1+"0");
            queue.add(s2+"1");
           
        }
    }

    static int connectNRopes(int [] nums){
        int min = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for ( int i = 0; i < nums.length; i++){
            
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]<nums[min]) {
                    min=j;
                }
            }
            queue.add(nums[min]);
            nums[min] = Integer.MAX_VALUE;
        }
        int cost=0,sum=queue.remove();
        while(!queue.isEmpty()) {
            sum = sum+queue.remove();
            cost = cost + sum;

        }
        return cost;
    }

    static int minCOst(int[]nums, int n){
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
        for(int i=0; i<n; i++){
            queue.add(nums[i]);
        }
        int cost=0;
        while (queue.size()>1) {
            int first = queue.remove();
            int second = queue.remove();
            cost+=first+second;
            queue.add(first+second);
        }
        System.out.println("Min cost is : " + cost);
        return cost;
    }

    public static void reverseKElement(Queue<Integer> queue,int K) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < K; i++) {
            stack.push(queue.remove());
        }
        for (int i = 0; i < K; i++) {
            queue.add(stack.pop());
        }
        int size  = queue.size();
        int j=0;
        while (j<size-K) {
            queue.add(queue.remove());
            j++;
        }
        
    }



    public static void main(String[] args){
        Queue63 temp = new Queue63();
        // DequeJCF deque = temp.new DequeJCF();

        // StackDeque <Character> stack = temp.new StackDeque<Character>();
        // stack.push('a');
        // stack.push('b');
        // stack.push('c');
        // while (!stack.isEmpty()) {
        //     System.out.println(stack.peek());
        //     stack.pop();
        // }

        // QueueDeque<Integer> queueDeque = temp.new QueueDeque<>();
        // queueDeque.enqueue(1);
        // queueDeque.enqueue(2);
        // queueDeque.enqueue(3);
        // while (!queueDeque.isEmpty()) {
        //     System.out.println(queueDeque.peek());
        //     queueDeque.dequeue();
        // }

        // generateBinaryNumbersQueue(10);


        // System.out.println(connectNRopes(new int[]{4,3,2,6}));

        // minCOst(new int[]{4,3,2,6}, 4);

        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        reverseKElement(queue, 5);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}