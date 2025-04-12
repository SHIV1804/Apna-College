
public class diagonalSum16 {
    static void diagonalSum(int[][] nums) {
        int sum = 0;
        int j = 0, n = nums.length;
        for (int i = 0; i < n; i++,j++) {
            sum += nums[i][i];
           
            if (i != n - j - 1) {
                sum += nums[i][n - j - 1];
                
            }
        }
        System.out.println("Diagonal sum: " + sum);
    }

    public static void main(String[] args) {
        int [][] nums = {{0, 1, 2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
        diagonalSum(nums);
    }
}
