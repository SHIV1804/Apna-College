import java.util.*;

public class Stack60 {
    
    public static int Histogram(int [] nums){
        int [] nextSmallestLeft = new int[nums.length];
        int [] nextSmallestRight = new int[nums.length];
        nextSmallestLeft = nextSmallestLeft(nums);
        nextSmallestRight = nextSmallestRight(nums);
        int max =0;
        for (int i = 0; i < nums.length; i++) {
            int area = nums[i]*(nextSmallestRight[i]-nextSmallestLeft[i]-1);
            System.out.print(area+" ");
            
            if (area>max) {
                max = area;
            }
        }
        System.out.println();
        System.out.println("Max area in histogram : " + max);
        return max;
    }


    public static boolean duplicateParantheses(String string){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<string.length(); i++){
            Character temp = string.charAt(i);
            if (temp!=')') {
                stack.push(temp);
            }else{
                int count =0;
                while (stack.pop()!='(') {
                    count++;
                }
                if (count<1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validParantheses(String string){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<string.length(); i++){
            Character temp = string.charAt(i);
            if (temp=='('||temp=='{'||temp=='[') {
                stack.push(temp);
            }else{
                if ((stack.peek()=='('&&temp==')')||(stack.peek()=='{'&&temp=='}')||(stack.peek()=='['&&temp==']')) {
                    stack.pop();
                }else return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }else return false;
    }


    public static int[] nextSmallestRight(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(nums.length-1);
        int nextSmallest[]= new int[nums.length];
        nextSmallest[nums.length-1]=nums.length;
        for (int i = nums.length-2; i >0; i--) {
            while (!stack.isEmpty()&&nums[i]<=nums[stack.peek()]) {
                stack.pop();
            }
            nextSmallest[i]=stack.isEmpty()?nums.length:stack.peek();
            stack.push(i);
        }
        return nextSmallest;
    }

    public static int[] nextSmallestLeft(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int nextSmallest[]= new int[nums.length];
        nextSmallest[0]=-1;
        for (int i = 0; i <nums.length; i++) {
            while (!stack.isEmpty()&&nums[i]<=nums[stack.peek()]) {
                stack.pop();
            }
            nextSmallest[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return nextSmallest;
    }
    public static int [] nextGreaterLeft(int [] nums){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(nums[0]);
        int nextGreater[]= new int[nums.length];
        nextGreater[0]=-1;
        for (int i = 0; i <nums.length; i++) {
            while (!stack.isEmpty()&&nums[i]>=stack.peek()) {
                stack.pop();
            }
            nextGreater[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i]);
        }
        return nextGreater;
    }


    public static int [] nextGreaterRight(int [] nums){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(nums[nums.length-1]);
        int nextGreater[]= new int[nums.length];
        nextGreater[nums.length-1]=-1;
        for (int i = nextGreater.length-2; i >-1; i--) {
            while (!stack.isEmpty()&&nums[i]>=stack.peek()) {
                stack.pop();
            }
            nextGreater[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i]);
        }
        return nextGreater;
    }

    public static int[] stockSpan(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] span = new int[nums.length];
        int i = 0;
        while (i < nums.length) {
                while ((!stack.isEmpty()) && nums[i] >= nums[stack.peek()]) {
                    stack.pop();
                }
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
            i++;
        }
        return span;
    }

    public static void putAtBottom(Stack<Integer> stack, Integer data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        Integer top = stack.pop();
        putAtBottom(stack, data);
        stack.push(top);

    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        putAtBottom(stack, top);

    }

    public static StringBuilder reverseString(StringBuilder string) {
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while (i < string.length()) {
            stack.push(string.charAt(i++));
        }
        StringBuilder temp = new StringBuilder();
        while (!stack.isEmpty()) {
            temp.append(stack.pop());
        }
        return temp;
    }

    public static void main(String[] args) {
        StringBuilder string = new StringBuilder("abc");

        Stack<Integer> stack = new Stack<>();
        string = reverseString(string);
        System.out.println(string);
        String temp = "abc";
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverseStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println(" Stock span : ");
        int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        int[] span = new int[stocks.length];
        span = stockSpan(stocks);
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }

        System.out.println("nextGreater Right : ");
        int[] nums = {6,8,0,1,2};
        int [] nextGreater = new int[nums.length];
        nextGreater=nextGreaterRight(nums);
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();
        System.out.println("nextGreater Left : ");
        nextGreater=nextGreaterLeft(nums);
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();
        System.out.println("nextSmallest Right : ");
        nextGreater=nextSmallestRight(nums);
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i]+" ");
        }

        System.out.println();
        System.out.println("nextSmallest Left : ");
        nextGreater=nextSmallestLeft(nums);
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i]+" ");
        }

        System.out.println();
        System.out.println("Valid parantheses : ");
        String parantheses = "{()()[]}";
        System.out.println(validParantheses(parantheses));

        System.out.println();
        System.out.println("Valid parantheses : ");
        String expression = "(a+b)";
        System.out.println(duplicateParantheses(expression));


        System.out.println();
        int [] heights= {2,1,5,6,2,3};
        Histogram(heights);
    }


    
}
