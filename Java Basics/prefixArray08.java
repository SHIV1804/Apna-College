import java.util.*;


public class prefixArray08 {

    static void prefixSum(int arr[]){
        int prefixArr[] = new int[arr.length];
        prefixArr[0] = arr[0];
        int max=0;
        for (int i = 1; i < arr.length; i++) {

            prefixArr[i]=arr[i]+prefixArr[i-1];
        }

        for (int i = 0; i < prefixArr.length; i++) {
            for (int j = 0; j < prefixArr.length; j++) {
                if (i==0) {
                    if (max<prefixArr[j]) {
                        max = prefixArr[j];
                    }

                }
                else{
                    if (max<prefixArr[j]-prefixArr[i-1]) {
                        max = prefixArr[j];
                    }
                }
            }
        }
        System.out.println(max);
    }

    

public static void main(String[] args) {
    int arr[]={1,2,3,4,-5,6,7,8,-9,-10};
    prefixSum(arr);
    
}
    
}
