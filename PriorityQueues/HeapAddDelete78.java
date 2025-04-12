
package PriorityQueues;

import java.util.*;

public class HeapAddDelete78 {

    static class MaxHeap {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        int peek() {
            return nums.get(0);
        }

        boolean isEmpty() {
            return nums.size() == 0;
        }

        void add(int val) {
            nums.add(val);
            int x = nums.size() - 1;
            int parentIndex = (x - 1) / 2;
            while (nums.get(x) > nums.get(parentIndex)) {
                int temp = nums.get(x);
                nums.set(x, nums.get(parentIndex));
                nums.set(parentIndex, temp);
                x = parentIndex;
                parentIndex = (x - 1) / 2;
            }
        }

        int remove() {
            int data = nums.get(0);

            int temp = nums.get(0);
            nums.set(0, nums.get(nums.size() - 1));
            nums.set(nums.size() - 1, temp);

            nums.remove(nums.size() - 1);
            heapify(0);
            return data;
        }

        void heapify(int val) {
            int leftIndex = val * 2 + 1;
            int rightIndex = val * 2 + 2;
            int maxIndex = val;
            if (leftIndex < nums.size() && nums.get(leftIndex) > nums.get(maxIndex)) {
                maxIndex = leftIndex;
            }
            if (rightIndex < nums.size() && nums.get(rightIndex) > nums.get(maxIndex)) {
                maxIndex = rightIndex;
            }
            if (maxIndex != val) {
                int temp = nums.get(maxIndex);
                nums.set(maxIndex, nums.get(val));
                nums.set(val, temp);
                heapify(maxIndex);
            }
        }
    }

    static class MinHeap {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        void add(int val) {
            nums.add(val);
            int childIndex = nums.size() - 1;
            int parentIndex = (childIndex - 1) / 2;
            while (nums.get(childIndex) < nums.get(parentIndex)) {
                int temp = nums.get(childIndex);
                nums.set(childIndex, nums.get(parentIndex));
                nums.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
        }

        int peek() {
            return nums.get(0);
        }

        boolean isEmpty() {
            return nums.size() == 0;
        }

        void heapify(int index) {
            int leftIndex = index * 2 + 1;
            int rightIndex = index * 2 + 2;
            int minIndex = index;

            if (leftIndex < nums.size() && nums.get(minIndex) > nums.get(leftIndex))
                minIndex = leftIndex;
            if (rightIndex < nums.size() && nums.get(minIndex) > nums.get(rightIndex))
                minIndex = rightIndex;
            if (minIndex != index) {
                int temp = nums.get(index);
                nums.set(index, nums.get(minIndex));
                nums.set(minIndex, temp);
                heapify(minIndex);
            }
        }

        int remove() {
            int data = nums.get(0);

            int temp = nums.get(0);
            nums.set(0, nums.get(nums.size() - 1));
            nums.set(nums.size() - 1, temp);
            nums.remove(nums.size() - 1);
            heapify(0);

            return data;
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        for (int i = 0; i < 10; i++) {
            minHeap.add((int) Math.ceil(Math.random() * 100));
        }
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.peek() + " ");
            minHeap.remove();
        }
        System.out.println();
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < 10; i++) {
            maxHeap.add((int) Math.ceil(Math.random() * 100));
        }
        while (!maxHeap.isEmpty()) {

            System.out.print(maxHeap.peek() + " ");
            maxHeap.remove();

        }
    }

}