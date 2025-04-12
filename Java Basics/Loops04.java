import java.util.*;
public class Loops04 {
    public static void main(String[] args) {
        int i,even=0,odd=0,length;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Integer : ");
        length = sc.nextInt();
        for (int j = 0; j < length; j++) {
            i= sc.nextInt();
            if (i%2 == 0) {
                even+=i;
            }else{
                odd+=i;
            }
            System.out.println("Total of even : " + even + "\nodd : " + odd);
        }

        System.out.println("Enter number for which you want to calculate factorial : ");
        i=sc.nextInt();
        int factorial=1;
        while (i!=0) {
           factorial*=i;
            i--;
        }
        System.out.println(factorial);
    }
}
