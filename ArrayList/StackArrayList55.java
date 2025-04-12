package ArrayList;

import java.util.ArrayList;

public class StackArrayList55 {
    static class Stack {
        ArrayList list = new ArrayList();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if (list.size() == 0) {
                return Integer.MIN_VALUE;
            }
            int top = (int) list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public int peek() {
            return (int) list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        for (int i = 0; i < 10; i++) {
            s.push(i);
        }
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
