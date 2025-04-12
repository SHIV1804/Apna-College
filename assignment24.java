import java.util.*;

public class assignment24 {
    static void swap(int i, int j) {
        System.out.println("i and j value before swapping : \n"+"i : "+i+"\nj : "+j);
        i=i^j;
        j=i^j;
        i=i^j;
        System.out.println("i and j value after swapping : \n"+"i : "+i+"\nj : "+j);
    }

    static void addOne(int number){
        System.out.println(-(~number));
    }
    static void upperToLower(char character){
        System.out.println("Before : " + character);
        character = (char)(character|' ');
        System.out.println("After : " + character);
    }
    static void lowerToUpper(char character){
        System.out.println("Before : " + character);
        character = (char)(character&(~(' ')));
        System.out.println("After : " + character);
    }
    public static void main(String[] args) {
        // swap(1, 0);
        // addOne(99);
        // upperToLower('A');
        // lowerToUpper('a');
        
    }
}
