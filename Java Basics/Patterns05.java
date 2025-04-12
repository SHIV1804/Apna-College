import java.util.*;

public class Patterns05 {

    void HOLLOWRECTANGLE(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1)
                    System.out.print("*");
                else if (j == 0 || j == n - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    void INVERTEDROTATEDHALFPYRAMID(int n) {
        for (int i = 0; i < n; i++) {
            int space = n - i - 1;
            for (int j = 0; j < n; j++) {
                if (space > j)
                    System.out.print(" ");

                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    void INVERTEDHALFPYRAMID(int n) {
        for (int i = n; i > 0; i--) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j);

            }
            System.out.println();
        }
    }

    void FLOYDSTriangle(int n) {
        int number = 1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i + 1; j++) {
                System.out.print(number++);
            }
            System.out.println();
        }
    }

    void Triangle01(int n) {

        for (int i = 0; i < n; i++) {
            boolean bool = (i % 2 == 0) ? true : false;
            for (int j = 0; j < i + 1; j++) {

                System.out.print((bool) ? 1 : 0);
                bool = !bool;
            }

            System.out.println();
        }
    }

    // static int findP(int i,int val,int p){

    // if (i%2==0) {
    // if (i<=val/2) {
    // p=i;
    // }else if(val/2<i-1){
    // p--;
    // }
    // }else{
    // if (i<=(val/2)+1) {
    // p=i;
    // }
    // else p=p-1 ;
    // }
    // return p;
    // }
    void butterFlyPattern(int n) {
        int p = 1;
        int space = n;
        for (int i = 1; i <= n; i++) {

            if (n % 2 == 0) {

                if (i <= n / 2) {
                    p = i;
                    space = space - 2;
                } else if (n / 2 < i - 1) {
                    p--;
                    space += 2;
                }
            } else {
                if (i <= (n / 2) + 1) {
                    p = i;
                    space = space - 2;
                } else {
                    p = p - 1;
                    space += 2;
                }
            }

            for (int j = 1; j <= n; j++) {

                if (j <= p || p + space < j)
                    System.out.print("*");
                else if (p < j && j <= p + space)
                    System.out.print(" ");
            }

            System.out.println();
        }
    }

    void solidRhombus(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n + n - i; j++) {

                if (j <= n - i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }

            System.out.println();
        }
    }

    void hollowRhombus(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n + n - i; j++) {

                if (j <= n - i)
                    System.out.print(" ");
                else {
                    if (j == n - i + 1 || j == n + n - i || i == 1 || i == n + n - i)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    void numberPyramid(int n) {
        int number = 1;
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if (j <= n - i)
                    System.out.print(" ");
                else
                    System.out.print(number);

            }
            number++;
            System.out.println();
        }

    }

    void palindRomicPattern(int n) {
        int number;
        for (int i = 1; i <= n; i++) {
            number = i + 1;
            for (int j = 1; j <= n + i - 1; j++) {

                if (j <= n - i)
                    System.out.print(" ");
                else {
                    if (j <= n) {
                        System.out.print(--number);
                    } else
                        System.out.print(++number);
                }

            }

            System.out.println();
        }

    }

    
    void diamondPattern(int n) {

        

        int space = n-1;
        for (int i = 1; i <= n*2-1; i++) {
            
            for (int j = 1; j <= n+n-space-1; j++) {

               if (j<=space) {
                System.out.print(" ");
               }else{
                System.out.print("*");
               }
            }
            space = i<n?space-1:space+1;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        Patterns05 pattern = new Patterns05();
        // pattern.HOLLOWRECTANGLE(val);
        // System.out.println();
        // pattern.INVERTEDROTATEDHALFPYRAMID(val);
        // pattern.INVERTEDHALFPYRAMID(val);
        // pattern.FLOYDSTriangle(val);
        // pattern.Triangle01(val);
        // pattern.butterFlyPattern(val);
        // pattern.solidRhombus(val);
        // pattern.hollowRhombus(val);
        // pattern.numberPyramid(val);
        // pattern.palindRomicPattern(val);
        pattern.diamondPattern(val);
    }
}
