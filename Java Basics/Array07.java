import java.util.*;

public class Array07 {
    static void subarray(int[] arr){
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    System.out.print(" " +arr[k]+" ");
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    static void subArrayMax(int[] arr){
        int sum = 0,largest = 0,smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                sum=0;
                for (int k = i; k <= j; k++) {
                sum=sum +arr[k];
                   
                }
                if (sum>largest) {
                    largest=sum;
                }
                if (smallest>sum) {
                    smallest=sum;
                }

                
            }
            
        }
        System.out.println("Smallest number : "+smallest);
        System.out.println("Largest number : "+largest);
    }


    

    public static void main(String[] args) {
        int arr []= {1,2,3,4};
        subarray(arr);
        subArrayMax(arr);
    }
}
