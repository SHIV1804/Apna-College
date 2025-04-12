import java.util.*;


public class Assingment12 {

    static void distinctNumbers(int [] arr){
        boolean bool = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] ==arr[i]) {
                    bool=true;
                    break;
                }
                
            }
        }
        System.out.println(bool);
    }



    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        distinctNumbers(nums);
    }
}
