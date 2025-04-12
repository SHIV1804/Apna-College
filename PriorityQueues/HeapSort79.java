
package PriorityQueues;

import java.util.*;

public class HeapSort79 {

    public static void heapSortAssendingOrder(int[] nums, int n) {
        // step 1: make min/max heap
        for (int i = n / 2; i >= 0; i--) {
            heapifyMaxHeap(nums, i, n);
        }
        // step 2: sort min/max heap
        for (int i = n-1; i > 0; i--) {
            swap(nums, 0, i);
            heapifyMaxHeap(nums, 0, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void heapifyMaxHeap(int[] nums, int i, int n) {
        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;
        int maxIndex = i;
        if (leftIndex < n && nums[leftIndex] > nums[maxIndex]) {
            maxIndex = leftIndex;
        }
        if (rightIndex < n && nums[rightIndex] > nums[maxIndex]) {
            maxIndex = rightIndex;
        }
        if (maxIndex != i) {
            swap(nums, i, maxIndex);
            heapifyMaxHeap(nums, maxIndex,n);
        }
    }

    



    public static void heapSortDescendingOrder(int[] nums, int n) {
        // step 1: make min/max heap
        for (int i = n / 2; i >= 0; i--) {
            heapifyMinHeap(nums, i, n);
        }
        // step 2: sort min/max heap
        for (int i = n-1; i > 0; i--) {
            swap(nums, 0, i);
            heapifyMinHeap(nums, 0, i);
        }
    }

    private static void heapifyMinHeap(int[] nums, int i, int n) {
        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;
        int minIndex = i;
        if (leftIndex < n && nums[leftIndex] < nums[minIndex]) {
            minIndex = leftIndex;
        }
        if (rightIndex < n && nums[rightIndex] < nums[minIndex]) {
            minIndex = rightIndex;
        }
        if (minIndex != i) {
            swap(nums, i, minIndex);
            heapifyMinHeap(nums, minIndex,n);
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)Math.ceil(Math.random()*100);
        }
        heapSortAssendingOrder(nums, nums.length);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        heapSortDescendingOrder(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

}