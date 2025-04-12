package ArrayList;

import java.util.ArrayList;

public class BeautifulArray48 {
    public static int[] beautifulArray(int n) {

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        while (nums.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) * 2 <= n) {
                    temp.add(nums.get(i) * 2);
                }
            }
            for (int i = 0; i < nums.size(); i++) {
                if ((nums.get(i) * 2) - 1 <= n) {
                    temp.add((nums.get(i) * 2) - 1);
                }
            }
            nums = temp;
        }
        return nums.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums = beautifulArray(5);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");

        }
    }
}
