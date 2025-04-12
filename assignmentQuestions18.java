import java.util.*;
public class assignmentQuestions18 {

    static void repeatations(int [][]nums,int number){
        int count = 0;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == number) {
                    count++;
                }
                if (j>0&&j<nums.length-1) {
                    sum+=nums[i][j];
                }
            }
        }
        System.out.println("Count: " + count);
        System.out.println("Sum: " +sum);
    }
    static void transposeMatrix(int [][]nums){
        int [][]transpose = new int[nums[0].length][nums.length];
        for (int i = 0; i < nums[0].length; i++) {
            for (int j = 0; j < nums.length; j++) {
                transpose[i][j] = nums[j][i];
            }
        }
        for (int i = 0; i < nums[0].length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(transpose[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][] nums = {{0, 1, 2},{4,5,6},{8,9,10},{12,1,14}};

        // repeatations(nums, 1);
        transposeMatrix(nums);
    }
}
