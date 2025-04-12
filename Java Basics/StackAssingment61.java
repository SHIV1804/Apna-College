import java.util.*;

public class StackAssingment61 {
    
    public static boolean isPalindrome(LinkedList<Character> list) {
        int size  = list.size();
        int mid = size/2;
        int i=0;
        Stack <Character> stack = new Stack<Character>();
        while (i<mid) {
            stack.push(list.get(i));
            i++;
        }
        mid = size%2==0?mid:mid+1;
        i=mid;
        while (i<size) {
            if (stack.pop()!=list.get(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<Character>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('A');
        list.add('B');
        System.out.println(isPalindrome(list));
    }
}
