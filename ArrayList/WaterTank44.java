package ArrayList;

import java.util.*;

public class WaterTank44 {

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

    public static int waterTank(ArrayList<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            int ht = Math.min(height.get(right), height.get(left));
            int width = right - left;
            int area = ht * width;
            max = Math.max(max, area);
            if (height.get(left) < height.get(right)) {
                left++;
            } else
                right--;
        }
        return max;
    }

    public static void main(String[] args) {

        ArrayList<Integer> height = new ArrayList<>();
        input(height);
        System.out.println(waterTank(height));

    }
}
