package Queue;

import java.util.*;;

public class Queue62 {
    class Queue {
        int[] nums;
        int rear;

        Queue(int size) {
            nums = new int[size];
            rear = -1;
        }

        boolean isEmpty() {
            return rear == -1;
        }

        void add(int data) {
            rear++;
            nums[rear] = data;
        }

        int remove() {
            if (isEmpty())
                return -1;
            int temp = nums[0];
            for (int i = 0; i < rear; i++) {
                nums[i] = nums[i + 1];
            }
            rear--;
            return temp;
        }

        int peek() {
            if (isEmpty()) {
                return -1;
            }
            return nums[0];
        }
    }

    class circulaQueue {
        int[] nums;
        int rear;
        int front;

        circulaQueue(int size) {
            nums = new int[size];
            rear = front = -1;
        }

        boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        boolean isFull() {
            return front == (rear + 1) % nums.length;
        }

        void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full.");
                return;
            }
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % nums.length;
            nums[rear] = data;
        }

        int remove() {
            if (isEmpty()) {
                return -1;
            }
            int temp = nums[front];
            if (front == rear) {
                front = rear = -1;
                return temp;
            }
            front = (front + 1) % nums.length;
            return temp;
        }

        int peek() {
            return nums[front];
        }
    }

    static Node head = null, tail = null;

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public class QueueLL {

        boolean isEmpty() {
            return head == null && tail == null;
        }

        void add(int data) {
            if (isEmpty()) {
                head = tail = new Node(data);
                return;
            }
            Node temp = new Node(data);
            tail.next = temp;
            tail = temp;
        }

        int remove() {
            if (isEmpty()) {
                return -1;
            }
            int temp = head.data;
            if (head.next == null) {
                head = tail = null;
                return temp;
            }
            head = head.next;
            return temp;
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
            }
            return head.data;
        }
    }

    public class QueueStackPush {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        void add(int data) {
            if (stack1.isEmpty()) {
                stack1.add(data);
                return;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.add(data);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        int remove() {
            if (stack1.isEmpty()) {
                return -1;
            }
            return stack1.pop();
        }

        int peek() {
            if (stack1.isEmpty()) {
                return -1;
            }
            return stack1.peek();
        }

        boolean isEmpty() {
            return stack1.isEmpty();
        }
    }

    public class QueueStackPop {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        void add(int data) {
            stack1.add(data);
        }

        int remove() {
            if (stack1.isEmpty())
                return -1;
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            int temp = stack2.pop();
            while (!stack2.isEmpty())
                stack1.push(stack2.pop());
            return temp;
        }

        int peek() {
            if (stack1.isEmpty())
                return -1;
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            int temp = stack2.peek();
            while (!stack2.isEmpty())
                stack1.push(stack2.pop());
            return temp;
        }

        boolean isEmpty() {
            return stack1.isEmpty();
        }
    }

    public class StackQueuePush<T> {
        java.util.Queue<T> queue1 = new java.util.ArrayDeque<T>();
        java.util.Queue<T> queue2 = new java.util.ArrayDeque<T>();

        boolean isEmpty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }

        void push(T data) {
            if (isEmpty()) {
                queue1.add(data);
                return;
            }
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            queue1.add(data);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.remove());
            }
        }

        T pop() {
            if (isEmpty()) {
                return null;
            }
            return queue1.remove();
        }

        T peek() {
            return queue1.peek();
        }

    }

    public class StackQueuePop<T> {
        java.util.Queue<T> queue1 = new java.util.ArrayDeque<T>();
        java.util.Queue<T> queue2 = new java.util.ArrayDeque<T>();

        boolean isEmpty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }

        void push(T data) {
            if (!queue1.isEmpty()) {
                queue1.add(data);
            } else {
                queue2.add(data);
            }
        }

        T pop() {
            if (isEmpty())
                return null;
            T top = null;
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    top = queue1.remove();
                    if(queue1.isEmpty()) break;
                    queue2.add(top);
                }
            }else{
                while (!queue2.isEmpty()) {
                    top = queue2.remove();
                    if(queue2.isEmpty()) break;
                    queue1.add(top);
                }
            }
            return top;
        }
        T peek(){
            if (isEmpty())
            return null;
        T top = null;
        if (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                top = queue1.remove();
                queue2.add(top);
            }
        }else{
            while (!queue2.isEmpty()) {
                top = queue2.remove();
                queue1.add(top);
            }
        }
        return top;
        }

    }


    public static void firstNonRepeatingCharacter(String string){
        java.util.Queue<Character> queue = new java.util.LinkedList<Character>();
        int [] freq = new int[26];
        for (int i = 0; i < string.length(); i++) {
            Character ch = string.charAt(i);
            queue.add(ch);
            freq[ch-'a']++;
            while (!queue.isEmpty()&&freq[queue.peek()-'a']>1) {
                queue.remove();
            }
            if (queue.isEmpty()) {
                System.out.print(-1+" ");
            }else
                System.out.print(queue.peek()+" ");
        }

    }

    public static <T> void interLeave(java.util.Queue<T> queue) {
        java.util.Queue <T> temp = new LinkedList<T>();
        int size = queue.size();
        for (int i = 0; i < size/2; i++) {
            temp.add(queue.remove());
        }
        for (int i = 0; i <size/2; i++) {
            queue.add(temp.remove());
            queue.add(queue.remove());
        }
    }   

    public static <T> void queueReversal(java.util.Queue<T> queue){
        Stack<T> temp = new Stack<T>();
        while (!queue.isEmpty()) {
            temp.add(queue.remove());
        }
        while (!temp.isEmpty()) {
            queue.add(temp.pop());
        }
    }
    

    public static void main(String[] args) {
        Queue62 temp = new Queue62();
        // Queue queue = temp.new Queue(5);
        // queue.add(0);
        // queue.add(1);
        // queue.add(2);
        // queue.add(3);
        // while(!queue.isEmpty()){
        // System.out.println(queue.peek());
        // queue.remove();
        // }
        // System.out.println("Circular queue : ");
        // circulaQueue cQueue = temp.new circulaQueue(3);
        // cQueue.add(1);
        // cQueue.add(2);
        // cQueue.add(3);
        // System.out.println(cQueue.remove());
        // System.out.println(cQueue.remove());
        // cQueue.add(4);
        // cQueue.add(5);
        // while (!cQueue.isEmpty()) {
        // System.out.print(cQueue.remove()+" ");
        // }

        // QueueLL queueLL = temp.new QueueLL();
        // queueLL.add(1);
        // queueLL.add(2);
        // queueLL.add(3);
        // queueLL.add(4);
        // while (!queueLL.isEmpty()) {
        // System.out.println(queueLL.peek());
        // queueLL.remove();
        // }

        // QueueStackPush queueStackPush = temp.new QueueStackPush();
        // queueStackPush.add(1);
        // queueStackPush.add(2);
        // queueStackPush.add(3);
        // queueStackPush.add(4);
        // while (!queueStackPush.isEmpty()) {
        // System.out.print(queueStackPush.peek()+" ");
        // queueStackPush.remove();
        // }

        // QueueStackPop queueStackPop = temp.new QueueStackPop();
        // queueStackPop.add(1);
        // queueStackPop.add(2);
        // queueStackPop.add(3);
        // queueStackPop.add(4);
        // while (!queueStackPop.isEmpty()) {
        // System.out.print(queueStackPop.peek()+" ");
        // queueStackPop.remove();
        // }

        // StackQueuePush<Character> stackQueuePush = temp.new
        // StackQueuePush<Character>();
        // stackQueuePush.push('a');
        // stackQueuePush.push('b');
        // stackQueuePush.push('c');
        // while (!stackQueuePush.isEmpty()) {
        // System.out.println(stackQueuePush.peek());
        // stackQueuePush.pop();
        // }

        // StackQueuePop<Character> stackQueuePop = temp.new StackQueuePop<Character>();
        // stackQueuePop.push('a');
        // stackQueuePop.push('b');
        // stackQueuePop.push('c');
        // while (!stackQueuePop.isEmpty()) {
        //     System.out.println(stackQueuePop.peek());
        //     stackQueuePop.pop();
        // }

        // firstNonRepeatingCharacter("aabccxb");


        // java.util.Queue<Integer> queue = new LinkedList<>();
        // for (int i = 0; i < 10; i++) {
        //     queue.add(i);
        // }
        // interLeave(queue);
        // while (!queue.isEmpty()) {
        //     System.out.print(queue.remove()+" ");
        // }


        // queueReversal(queue);
        // while (!queue.isEmpty()) {
        //         System.out.print(queue.remove()+" ");
        //     }



    }
}
