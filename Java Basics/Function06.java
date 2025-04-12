import java.util.*;






public class Function06 {
    static void sumOfDigits(int n){
        
       
        int sum=0;
        // if(n<=10) return false;
        while (n>0) {
            sum = sum + n%10;
            n/=10;
        }
        System.out.println("Sum of digits: " + sum);
    }


    static boolean isPalindrome(int n){
        if (n<=10) {
            return false;
        }
        int nCopy = n;
        int decimal=0;
        // if(n<=10) return false;
        while (n>0) {
            decimal = decimal*10 + n%10;
            n/=10;
        }
        if (nCopy==decimal) return true;
        else return false;
    }

    static boolean isEven(int n){
        if (n%2==0) {
            return true;
        }
        return false;
    }


    static void BinaryTodeci(int n){
        int mod =0;
        int pow = 0;
        int dec = 0;
        while (n>0) {
            dec = dec+((n%10)*(int)Math.pow(2, pow));
            n/=10;
            pow++;
        }
        System.out.println("Decimal decoding : " + dec);
    }
    static void deciToBinary(int n){
        int mod =0;
        int pow = 0;
        int dec = 0;
        while (n>0) {
            dec = dec+((n%2)*(int)Math.pow(10, pow));
            n/=2;
            pow++;
        }
        System.out.println("Binary decoding : " + dec);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt();
        // BinaryTodeci(m);
        // int n = scanner.nextInt();
        // deciToBinary(n);
        // if(isEven(m)) System.out.println("Number is even");
        // else System.out.println("Number is odd");
        // if(isPalindrome(m)) System.out.println("Number is palindrome");
        // else System.out.println("Number is not palindrome");
        sumOfDigits(m);
    }
}
