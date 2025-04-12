package ArrayList;

import java.util.ArrayList;

public class FindLonely47 {
    // Approach -1

    public static ArrayList<Integer> findLonely(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        int j,k,i;
        for ( i = 0; i < nums.length; i++) {
            for (j = i+1; j < nums.length; j++) {
                if ( (nums[i] == nums[j] + 1 || nums[j] - 1 == nums[i] || nums[j] == nums[i])) {
                    break;
                }
            }
            for ( k = i-1; k >=0; k--) {
                if ( (nums[i] == nums[k] + 1 || nums[k] - 1 == nums[i] || nums[k] == nums[i])) {
                    break;
                }
            }
            if (k == -1&&j==nums.length) {
                temp.add(nums[i]);
            }

        }
        return temp;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums = findLonely(new int[] { 10, 6, 5, 8 });
        System.out.println(nums);
        System.out.println(findLonely(new int[] { 1, 3, 5, 3 }));
        System.out.println(findLonely(new int[] {75,35,59,66,69,53,37,16,60,98,11,33,3,85,59,65,59,44,34,89,72,47}));
    }
}
