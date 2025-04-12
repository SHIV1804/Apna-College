import java.util.*;

public class stairCaseSearch17 {
    static int stairCaseSearch(int [][]nums,int key){
        int i=0;
        int j=nums.length-1;
        int length=nums.length;
        while (i<length&&0<=j) {
            if (nums[i][j]==key) {
                return key;
            }else if (nums[i][j]>key) {
                j--;
            }else i++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int [][] nums = {{0, 1, 2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
        System.out.println(stairCaseSearch(nums, 1));
    }
}
