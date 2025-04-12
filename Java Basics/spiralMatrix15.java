import java.util.*;



public class spiralMatrix15 {
    static void spiralMatrix(int nums[][]){
        int startRow = 0,endRow=nums.length-1,startColumn=0,endColumn=nums.length-1;
        while (startRow<=endRow&&startColumn<=endColumn) {
            //top
            for (int i = startColumn; i <= endColumn; i++) {
                System.out.print(nums[startRow][i]+" ");
            }
            //right
            for (int i = startRow+1; i <= endRow; i++) {
                System.out.print(nums[i][endColumn]+" ");
            }
            //bottom
            for (int i = endColumn-1; i >=startColumn ; i--) {
                System.out.print(nums[endRow][i]+" ");
            }
            //left
            for (int i = endColumn-1; i >= startColumn+1; i--) {
                System.out.print(nums[i][startColumn]+" ");
            }
            startRow++;
            startColumn++;
            endRow--;
            endColumn--;
        }

    }
    public static void main(String[] args) {
        int nums[][]= {{0,1,2},{4,5,6},{8,9,10}};
        spiralMatrix(nums);
    }
}
