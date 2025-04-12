public class RotatedArray32 {

    // static int rotatedArray(int nums[], int taeget, int startIndex, int endIndex) {
    //     while (startIndex <= endIndex) {
    //         int mid = (startIndex + endIndex) / 2;

    //         if (nums[mid] == taeget) {
    //             return mid;
    //         }
    //         if (nums[startIndex] <= nums[mid]) {
    //             if (nums[startIndex] <= taeget && taeget <= nums[mid]) {
    //                 endIndex = mid - 1;
    //             } else {
    //                 startIndex = mid + 1;
    //             }
    //         } else {
    //             if (nums[mid] <= taeget && taeget <= nums[endIndex]) {
    //                 startIndex = mid + 1;
    //             } else {
    //                 endIndex = mid - 1;
    //             }
    //         }
    //     }
    //     return -1;
    // }


    static int rotatedArray(int nums[], int taeget, int startIndex, int endIndex) {
            if(startIndex>endIndex) return -1;
            int mid = (startIndex + endIndex) / 2;

            if (nums[mid] == taeget) {
                return mid;
            }
            if (nums[startIndex] <= nums[mid]) {
                if (nums[startIndex] <= taeget && taeget <= nums[mid]) {
                    return rotatedArray(nums, taeget, startIndex, mid-1);
                } else {
                    return rotatedArray(nums, taeget, mid+1, endIndex);
                }
            } else {
                if (nums[mid] <= taeget && taeget <= nums[endIndex]) {
                    return rotatedArray(nums, taeget, mid+1, endIndex);
                } else {
                    return rotatedArray(nums, taeget, startIndex, mid-1);
                }
            
        }
        
    }
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println(rotatedArray(nums, 2, 0, nums.length - 1));
    }
}
