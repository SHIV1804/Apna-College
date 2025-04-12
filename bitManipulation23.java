import java.util.*;

public class bitManipulation23 {
    static void operators(int number1,int number2){
        System.out.println(number1&number2);
        System.out.println(number1|number2);
        System.out.println(~number1);
        System.out.println(number1^number2);
        System.out.println(number1<<number2);
        System.out.println(number1>>number2);

    }
    static void oddEven(int number){
        if ((number&1)==0) {
            System.out.println("Number is even.");
        }else System.out.println("Number is odd.");
    }
    static void get(int number,int bitNumber){
        System.out.println("Bit at "+bitNumber+" is "+(number&(1<<bitNumber)));
    }
    static void set(int number,int bitNumber){
        System.out.println("After setting bit : "+(number|(1<<bitNumber)));
    }
    static int clear(int number,int bitNumber){
        System.out.println("After clearing bit : "+(number&(~(1<<bitNumber))));
        return (number&(~(1<<bitNumber)));
    }
    static void update(int number,int bitNumber,int newBit){
        // if (newBit==0) {
        //     clear(number, bitNumber);
        // }else set(number,bitNumber);

        //approach 2 - 
        number = clear(number, bitNumber);
        int bitMask = newBit<<bitNumber;
        System.out.println(number|bitMask);
    }




    static void clearInRange(int number,int bitNumber){
        int bitMask = (~0)<<bitNumber;
        System.out.println("After clearing : " + (number&bitMask));
    }
    static void clearInGivenRange(int number,int bitNumber1,int bitNumber2){
        int a=(~0)<<bitNumber2+1;
        int b=(1<<bitNumber1)-1;
        int bitMask= a|b;
        System.out.println("After clearing in given range : " + (number&bitMask));
    }

    static void powerOfTwo(int number){
        if ((number&(number-1))==0) {
            System.out.println("Number is in power of two.");
        }else{
            System.out.println("Number is not in power of two.");
        }
    }
    public static void main(String[] args) {
        // int a= 10;int b= 2;
        // operators(a, b);
        // oddEven(a);
        // get(a, b);
        // set(a, b);
        // clear(a, b);
        // update(a, b, 1);
        // clearInRange(a, b);
        // clearInGivenRange(a*1000, b,10 );
        powerOfTwo(32);
    }
}
