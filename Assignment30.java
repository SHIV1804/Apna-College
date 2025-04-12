import java.util.*;

public class Assignment30 {
    static String array[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static void keyOccurence(int nums[], int index, int key) {
        if (index == nums.length) {
            return;
        }
        if (key == nums[index]) {
            System.out.print(index + " ");
        }
        keyOccurence(nums, index + 1, key);

    }
    static void convertNumber(int number){
        if (number==0) return;
        
        convertNumber(number/10);
        int lastDigit = number%10;
        System.out.print(array[lastDigit]+" ");
    }

    static void convertNumberToString(Integer number, int lastDigit) {
        if (number==0) {
            return;
        }
        switch (lastDigit) {
            case 0:
                System.out.print("Zero ");
                break;
            case 1:
            System.out.print("One ");
                break;
            case 2:
            System.out.print("Two ");
                break;
            case 3:
            System.out.print("Three ");
                break;
            case 4:
            System.out.print("Four ");
                break;
            case 5:
            System.out.print("Five ");
                break;
            case 6:
            System.out.print("Six ");
                break;
            case 7:
            System.out.print("Seven ");
                break;
            case 8:
            System.out.print("Eight ");
                break;
            case 9:
            System.out.print("Nine ");
                break;

        }
        convertNumberToString(number/10,number%10);

    }

    static int Length(String string){
       
        if (string.length()==0) {
            return 0;
        }
        return Length(string.substring(1))+1;
    }

    static void substrings(String string,int index){
        
        if(string.length()==0||index<string.length()) return;
        System.out.println(string.substring(0,index));
        substrings(string,index+1);
        substrings(string.substring(1), index);
    }
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 1, 1, 1, 1, 1, 1, 1 };
        // keyOccurence(nums, 0, 1);
        // convertNumberToString(1947, 1);
        // convertNumber(1947);
        // System.out.println("Length of string : "+Length("abx"));
        // substrings("abc", 1);
        
    }
}
