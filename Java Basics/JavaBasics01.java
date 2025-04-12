import java.util.Scanner;
public class JavaBasics01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        System.out.println("Average : "+(A+B+C)/3);
        int side = sc.nextInt();
        System.out.println("Area : " + side*side);

        int pencil = sc.nextInt();
        int pen = sc.nextInt();
        int eraser = sc.nextInt();
        
        System.out.println("Pencil : " + (pencil+=((pencil*18)/100)));
        System.out.println("Pen : " + (pen+=((pen*18)/100)));
        System.out.println("Eraser : " + (eraser+=((eraser*18)/100)));
        System.out.println("Total : " + pencil+pen+eraser);

        int $ = 24;
        System.out.println($);


    }
}