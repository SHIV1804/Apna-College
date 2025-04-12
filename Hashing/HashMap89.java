package Hashing;

import java.util.*;

/**
 * HashMap89
 */
public class HashMap89 {

    static int countLargestSubArrayWithSumZero(int []nums){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum = 0,length=0;

        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (map.containsKey(sum)) {
                length = Math.max(length, i-map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return length;
    }
    
    public static void main(String[] args) {
        int nums[] = {15,-2,2,-1,-7,8,10};
        System.out.println(countLargestSubArrayWithSumZero(nums));
    }
}