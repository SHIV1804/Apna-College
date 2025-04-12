import java.util.Scanner;

public class Array06 {

    static void swap(int arr[],int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    static void print(int[] arr){
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    }

    static void menu(String list[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of Dish: ");
        String nameOfDish = scanner.next();
        int i;
        for ( i = 0; i < list.length; i++) {
            if (nameOfDish.equalsIgnoreCase(list[i])) {
                System.out.println("You want "+list[i]+"Its in index "+i);
                break;
            }
               
            
        }
        if(i==list.length) System.out.println("Your dish is not in menu");
    }

    static int largestNumber(int number[]){
        int largest = 0;
        for (int j = 0; j < number.length; j++) {
             if (largest<number[j]) {
            largest = number[j];
        }
        }
        return largest;
       
    }

    static int binarySearch(int arr[],int n){
        int i=0,j=arr.length-1;
        int mid ;

        while (i<=j) {
            mid =( i+j)/2;
            if (n==arr[mid]) {
                return i;
            }else if (arr[mid] < n) {
                i=mid+1;
            }else{
                j=mid-1;
            }
        }

        return -1;
    }

    static void reverseAnArray(int [] arr){
        int i=0,j=arr.length-1;
        while (i<j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static void pair(int[] arr){
        for (int i=0;i<arr.length;i++) {
            System.out.print(i+1+":");
            for (int j = i; j < arr.length; j++) {
                System.out.print("("+arr[i]+" "+arr[j]+")");
            }
            System.out.println();
        }
    }
    static void subarray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    System.out.print(" " +arr[k]+" ");
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String list[] = {"Palak paneer","Dosa","Idli","Samosa"};
        int number[] = {1,2,3,4};
        
        
        // menu(list);
        // System.out.println("Greatest number is : "+largestNumber(number));

        // int n=scanner.nextInt();
        // int index = binarySearch(number,n);
        // if (index == -1){
        //     System.out.println("Key not found");
        // }else{
        //     System.out.println("Key found and index is : "+index);
        // }

        // reverseAnArray(number);
        // print(number);
        // System.out.println();
        // pair(number);
        
        // subarray(number);


        

    }
}
