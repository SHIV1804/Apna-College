import java.util.*;

public class Operator03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i < 0) {
            System.out.println("Negative number");
        } else {
            System.out.println("Positive number");
        }

        double temp = 103.5;
        if (temp < 100)
            System.out.println("You dont have fever.");
        else
            System.out.println("You have fever.");

        i = sc.nextInt();

        switch (i) {
            case 0:
                System.out.println("Monday");
                break;
            case 1:
                System.out.println("Tuesday");
                break;
            case 2:
                System.out.println("Wednesday");
                break;
            case 3:
                System.out.println("Thursday");
                break;
            case 4:
                System.out.println("Friday");
                break;
            case 5:
                System.out.println("Saturday");
                break;
            

            default:
            System.out.println("Sunday");
                break;
        }

        int year = sc.nextInt();
        if (year%4==0) {
            if (year%100==0) {
                if (year%400==0) {
                    System.out.println("Leap year");
                }
                else System.out.println("Not a leap year"); 
            }else{
                System.out.println("Leap year");
            }
        }else{
            System.out.println("Not a leap year");
        }
    }
}
