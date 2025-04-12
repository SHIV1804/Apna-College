package ArrayList;

public class Monotonic46 {
    //Approach -1 
    public static boolean mono(int[] nums){
        int i=0;
        while(i<nums.length-1){
        if(nums[i]!=nums[i+1]){
            if(nums[i]<nums[i+1]){
                return true;
                
            }else return false;
            }
            i++;
            }
        return true;
    }
    public static boolean isMonotonic(int[] nums) {
        boolean mono = mono(nums);
        int i=0;
        while(i<nums.length-1){
            
            if(mono){
                if(nums[i]>nums[i+1]) return false;
            }
            if(!mono){
                if(nums[i]<nums[i+1]) return false;
            }
            i++;
            }
            return true;
    }
    //Approach -2
    public static boolean monotonic(int [] nums){
        boolean monotonicIncreasing = true;
        boolean monotonicDecreasing = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]>nums[i+1]) {
                monotonicIncreasing = false;
            }
            if (nums[i]<nums[i+1]) {
                monotonicDecreasing = false;
            }
        }
        return monotonicIncreasing||monotonicDecreasing; 
    }
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1,2,3}));
        System.out.println(monotonic(new int[]{1,2,3}));
    }
}
