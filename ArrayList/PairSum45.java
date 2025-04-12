package ArrayList;
import java.util.*;
public class PairSum45 {
        public static void input(ArrayList<Integer> nums) {
        int temp = 0;
        System.out.println("Enter -1 to  exit : ");
        Scanner scanner = new Scanner(System.in);

        while (temp != -1) { 
            temp = scanner.nextInt();
            if (temp != -1)
                nums.add(temp);

        }
    }
    public static boolean pairSumTwoPointer(ArrayList<Integer> nums,int target){
        int left =0;
        int right =nums.size()-1;
        for (int i = 0; i < nums.size(); i++) {
            int sum = nums.get(left)+nums.get(right);
            if (sum==target) {
                return true;
            }
            else if (sum<target) {
                left++;
            }
            else right--;

        }
        return false;
    }

     

    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<Integer>();
        input(list);
        System.out.println(pairSumTwoPointer(list, 10));
    }
}
