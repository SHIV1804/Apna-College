import java.util.*;

// approach -1 
// public class rotatedArray13 {

//     static int rotatedArray(int []nums,int target){
//         int length = nums.length;
//         int start=0;
//         int min = Integer.MAX_VALUE;
//         int minIndex=0;
//         for (int i = 0; i < length; i++) {
//             if (min>nums[i]) {
//                 minIndex=i;
//                 min=nums[i];
//             }
//         }

//         if (nums[0]<=target&&nums[minIndex-1]>=target) {
//             minIndex--;

//         }else{
//             start = minIndex;
//             minIndex = length;
//         }

//         //binary search 
//         while (start<=minIndex) {

//             int mid = (start+minIndex)/2;

//             if (nums[mid]==target) {
//                 return mid;
//             }else if (nums[mid]<target) {
//                 start = mid+1;
//             }else{
//                 minIndex =mid-1;
//             }
//         }
//         return -1;

//     }

//     public static void main(String[] args) {
//         int nums[]={3,4,5,0,1};
//         System.out.println(rotatedArray(nums, 5));
//     }
// }

// approach -2
public class rotatedArray13 {
    static int minSearch(int nums[]) {
        int left = 0, right = nums.length - 1;
        while (left < right) {

            int mid = (left + right) / 2;
           
            if ( mid > 0&&nums[mid] < nums[mid - 1] ) {
                return mid;
            } else if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    static int binarySearch(int[] nums, int left, int right, int target) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 8 }, target = 4;
        int minIndex = minSearch(nums);

        if (nums[minIndex] <= target && nums[nums.length - 1] >= target) {
            System.out.println(binarySearch(nums, minIndex, nums.length - 1, target));

        } else {
            System.out.println(binarySearch(nums, 0, minIndex, target));
        }
    }

}



    