public class Recursion26 {
    static void printDecreasingNumber(int value){
        System.out.print(value+" ");
        if (value==1) {
            return;
        }
        
        printDecreasingNumber(value-1);
    }
    static void printIncreasingNumber(int value){
      if (value==0) {
            
            return;
        }
        printIncreasingNumber(value-1);
        System.out.print(value+" ");
        
    }
    public static void main(String[] args) {
        // printDecreasingNumber(100);
        printIncreasingNumber(100);
    }
}
