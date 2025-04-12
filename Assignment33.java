import java.util.ArrayList;

public class Assignment33 {

    //**************************************************************************************
    static void majorityValues(int [] nums){
        int [] temp;
        int max = -109;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max) {
                max = nums[i];
            }
        }
        temp = new int[max+1];                                                                                           
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }
        max = -109;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i]>max) {
                max = temp[i];
            }
        }
        System.out.println(max);
        

    }








    //*************************************************************************************
    static void print(String string[]) {
        for (int i = 0; i < string.length; i++)
            System.out.print(string[i] + " ");
    }

    // Approach 2
    // ------------------------------------------------------------------------------------
    static String[] mergeSortString(String string[], int startIndex, int endIndex) {

        if (startIndex == endIndex) {
            String[] temp = { string[startIndex] };
            return temp;
        }

        int mid = (startIndex + endIndex) / 2;
        String string1[] = mergeSortString(string, startIndex, mid);

        String string2[] = mergeSortString(string, mid + 1, endIndex);

        String string3[] = mergeString(string1, string2);

        return string3;

    }

    static String[] mergeString(String string1[], String string2[]) {
        int n1 = string1.length;
        int n2 = string2.length;
        String string3[] = new String[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (isAlphabeticallySmaller(string1[i], string2[j])) {
                string3[k++] = string1[i++];
            } else {
                string3[k++] = string2[j++];
            }
        }
        while (i < n1) {
            string3[k++] = string1[i++];
        }
        while (j < n2) {
            string3[k++] = string2[j++];
        }

        return string3;
    }

    private static boolean isAlphabeticallySmaller(String string1, String string2) {
        if (string1.compareTo(string2) < 0) {
            return true;
        }
        return false;
    }

    // ------------------------------------------------------------------------------------
    // Approach 2
    // static void mergeSortString(String string[], int startIndex, int endIndex) {

    // if (startIndex >= endIndex) {
    // return;
    // }

    // int mid = (startIndex + endIndex) / 2;

    // mergeSortString(string, startIndex, mid);
    // mergeSortString(string, mid + 1, endIndex);
    // merge(string, startIndex, mid, endIndex);
    // }

    // static void merge(String string[], int startIndex, int mid, int endIndex) {
    // int temp = endIndex - startIndex + 1;
    // String[] tempArray = new String[temp];
    // int i = startIndex;
    // int j = mid + 1;
    // int k = 0;
    // // Entering sorted string in temp array
    // while (i <= mid && j <= endIndex) {
    // if (string[i].charAt(0) < string[j].charAt(0)) {
    // tempArray[k++] = string[i++];

    // } else {
    // tempArray[k++] = string[j++];
    // }
    // }
    // while (i <= mid) {
    // tempArray[k++] = string[i++];
    // }
    // while (j <= endIndex) {
    // tempArray[k++] = string[j++];
    // }

    // for (int k2 = 0; k2 < tempArray.length; k2++) {
    // string[startIndex++] = tempArray[k2];
    // }

    // **********************************************************************
    // Second way to merge the two strings array

    // int n1 = mid - startIndex + 1;
    // int n2 = endIndex - mid;
    // String[] Left = new String[n1];
    // String[] Right = new String[n2];
    // int j = startIndex;
    // int k = mid + 1;
    // for (int i = 0; i < Left.length; i++) {
    // Left[i] = string[j++];
    // }
    // for (int i = 0; i < Right.length; i++) {
    // Right[i] = string[k++];
    // }
    // int i = 0;
    // j = 0;
    // k = startIndex;
    // while (i < n1 && j < n2) {
    // if ((int)Left[i].charAt(0) <= (int)Right[j].charAt(0)) {
    // string[k++] = Left[i++];
    // } else {
    // string[k++] = Right[j++];
    // }
    // }
    // while (i < n1) {
    // string[k++] = Left[i++];
    // }
    // while (j < n2) {
    // string[k++] = Right[j++];
    // }

    public static void main(String[] args) {
        // String[] string = { "hello", "world", "ram", "a" };

        // String sortedString[] = mergeSortString(string, 0, string.length - 1);
        // print(sortedString);

        int [] nums = { 0, 0, 0, 0, 0, 0, 0, 0,1,1,2,2,2};
        majorityValues(nums);
    }
}
