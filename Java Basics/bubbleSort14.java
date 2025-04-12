import java.util.*;



public class bubbleSort14 {

    static void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    

    static int[] array(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length for array : ");
        int length = scanner.nextInt();
        int nums[] = new int[length];
        System.out.println("Enter values for array : ");
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }

    static void Print(int nums[]){
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println();
    }


    static void bubbleSort(int []nums){
        for (int i = 0; i < nums.length-1; i++) {
            int swap =0;
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j]>nums[j+1]) {
                    swap(nums, j, j+1);
                    swap++;
                }
            }
            if (swap==0)    break;
            
        }
        
    }

    static void selectionSort(int []nums){
        
        for (int i = 0; i < nums.length-1; i++) {
            int min =i;
            for (int j = i+1; j < nums.length; j++) {
                 if (nums[min]>nums[j]) {
                    min=j;
                 }

            }
            swap(nums, i, min);
        }
    }

    static void insertionSort(int[] nums){
        int j,i;
        for ( i = 1; i < nums.length; i++) {
            int element = nums[i];
            for ( j = i; j >0; j--) {
                if (element<=nums[j-1]) {
                    nums[j] = nums[j-1];
                } else{
                    
                    break;
                }
            }
            nums[j] = element;
        }
    }
 

    static void countingSort(int []nums){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(max<nums[i]) {
                max = nums[i];
            }
        }
        int frequency[]=new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            frequency[nums[i]]++;
        }
        int i=0,j=0;
        while (i<frequency.length) {
            if (frequency[i]>0) {
                nums[j]=i;
                j++;
                frequency[i]--;
            }else i++;
        }

    }


    public static void main(String[] args) {
            
        int nums[] = {3,2,4,1};
        // Print(nums);
        // bubbleSort(nums);
        // Print(nums);
        // selectionSort(nums);
        // Print(nums);
        // insertionSort(nums);
        countingSort( nums);
        Print(nums);
    }
}
