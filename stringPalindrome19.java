import java.util.*;

public class stringPalindrome19 {

    static boolean palindrome(String string) {

        for (int i = 0, j = string.length() - 1; i < j; i++, j--) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    static void shortestPath(String string) {
        int n = 0, m = 0;
        for (int i = 0; i < string.length(); i++) {

            switch (string.charAt(i)) {
                case 'n':
                case 'N':
                    m++;
                    break;
                case 's':
                case 'S':
                    m--;
                    break;
                case 'e':
                case 'E':
                    n++;
                    break;
                case 'w':
                case 'W':
                    n--;
                    break;
            }

        }

        int path = (int) Math.sqrt(Math.pow(Math.abs(m), 2) + Math.pow(Math.abs(n), 2));
        System.out.println("Shorter path: " + path);
    }

    public static void main(String[] args) {
        // String string = "racingcar";
        // System.out.println(palindrome(string));
        String path = "WNEENESENNN";
        shortestPath(path);
    }

}