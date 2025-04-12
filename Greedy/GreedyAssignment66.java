package Greedy;

import java.util.*;

class GreedyAssignment66{
    static void kthOddInRange(int l,int r,int k){
        int i=l%2==0?l+1:l;
        int val=0;
        while (i<=r) {
            if (k<=i) {
                val=i;
            }
            i+=2;
        }
        System.out.println("Largest odd value: " + val);
    }
    
    static void lexicographicallySmallestString(int N,int K){
        StringBuilder sb = new StringBuilder();

        for (int i = N-1; i >=0; i--) {
           int temp = K-i;
           if (temp>26) {
                temp = 26;
           }
           sb.append((char)(temp+96));
           K-=temp;
        }
        System.out.println(sb.reverse());
    }

    public static void stockProfit(int [] nums){
        int buy=nums[0];
        int maxProfit=0;
        for (int i = 1; i < nums.length; i++) {
            if (buy>nums[i]) {
                buy=nums[i];
            }else if (nums[i]-buy>maxProfit) {
                maxProfit=nums[i]-buy;
            }
        }
        System.out.println(maxProfit);
    }


    public static void main(String[] args) {
        // kthOddInRange(-3, 3, 1);

        // for (int i = 0; i < 26; i++) {
        //     System.out.println((char)('a'+i)+" "+(i+1));
        // }
        // lexicographicallySmallestString(5, 100);
        

        int[] nums = {7, 6, 4, 3, 1};
        stockProfit(nums);
    }
}