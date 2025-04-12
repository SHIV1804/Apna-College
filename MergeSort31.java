import java.util.*;

public class MergeSort31 {
    static void print(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    static void mergeSort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, end, mid);
    }

    static void merge(int arr[],int start,int end,int mid){
        
        int i=start,j=mid+1, k=0;
        int temp[] = new int[end-start+1];
        while (i<=mid&&j<=end){ {
            if (arr[i]<=arr[j]) {
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while (i<=mid) {
            temp[k++]=arr[i++];
        }
        while (j<=end) {
            temp[k++]=arr[j++];
        }
        k=start;
        for ( i = 0; i < temp.length; i++,k++) {
            arr[k]=temp[i];
        }
    }
    }
    public static void main(String[] args) {
        int nums[]= {1,2,3,4,5,6,0};
        print(nums);
        mergeSort(nums, 0, 6);
        System.out.println();
        print(nums);

    }
}
