import java.util.*;

public class Recursion27 {
    static int naturalSum(int value) {
        if (value <= 0)
            return 0;
        if (value == 1) {
            return 1;
        }
        return value + naturalSum(value - 1);
    }

    static int fibonacci(int value) {

        if (value == 1 || value == 0) {
            return value;
        }
        int fibn1 = fibonacci(value - 1);
        int fibn2 = fibonacci(value - 2);
        int fibn = fibn1 + fibn2;
        return fibn;
    }

    static boolean isSorted(int index, int arr[]) {
        if (arr[index] > arr[index + 1])
            return false;
        if (index == arr.length - 1) {
            return true;
        }
        return isSorted(index + 1, arr);
    }

    static int firstOccurence(int arr[], int index, int target) {
        if (arr[index] == target)
            return index;
        if (index == arr.length) {
            return -1;
        }
        return firstOccurence(arr, index + 1, target);

    }

    static int lastOccurence(int arr[], int index, int target) {

        if (index == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, index + 1, target);
        if (isFound == -1 && arr[index] == target)
            return index;
        return isFound;
    }

    static int numberPower(int number, int power) {
        if (power == 1) {
            return number;
        }
        return number * numberPower(number, power - 1);
    }

    static int numberPowerOptimized(int number, int power) {
        if (power == 0) {
            return 1;
        }
        int halfSquare = numberPowerOptimized(number, power / 2);
        int square = halfSquare * halfSquare;
        if (power % 2 != 0)
            square = number * square;
        return square;
    }

    public static void main(String[] args) {
        // System.out.println(naturalSum(10));
        // System.out.println(fibonacci(5));
        int nums[] = { 1, 2, 3, 4, 1, 0, 1, 5, 4 };
        // System.out.println(isSorted(0, nums));
        // System.out.println(firstOccurence(nums, 0, 4));
        // System.out.println(lastOccurence(nums, 0, 1));
        // System.out.println(numberPower(2, 10));
        // System.out.println("Power : " + numberPowerOptimized(2, 1));
    }
}
