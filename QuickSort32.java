import java.util.*;

public class QuickSort32 {
    static void print(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    static void quickSort(int arr[], int start, int end) {
        if (start >= end)
            return;
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    static int partition(int nums[], int start, int end) {
        int i = start - 1;
        int pivot = nums[end];
        for (int j = start; j <= end; j++) {
            if (nums[j] <= pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        // i++;
        // int temp = pivot;
        // nums[end] = nums[i];
        // nums[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,300,4,100,6,7,8};
        print(nums);
        quickSort(nums, 0, 7);
        System.out.println();
        print(nums);
    }
}
