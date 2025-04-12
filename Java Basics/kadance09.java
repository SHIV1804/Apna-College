import java.util.*;

public class kadance09 {

    static void kadance(int arr[]){
        int currentSum = 0,maxSum = Integer.MIN_VALUE,negativeSum=Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            
                negativeSum =Math.max(negativeSum,arr[i]) ;
            
            
            currentSum += arr[i];
            if (currentSum<0) {
                currentSum = 0;
            }
            maxSum = Math.max(currentSum,maxSum);
            
        }
        if (maxSum==0) {
            maxSum = negativeSum;
        }
        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        int arr[]={-2,-3,-1,-2,-3};
        kadance(arr);
    }
}
