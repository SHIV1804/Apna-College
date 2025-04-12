import java.util.*;
public class BinaryString29 {
    static void binaryString(int size,int lastIndex,String string){
        if (size == 0){
            System.out.println(string);
            return;
        }
        binaryString(size-1, 0, string+"0");
        if (lastIndex == 0) binaryString(size-1, 1, string+"1");
        
    }
    public static void main(String[] args) {
        binaryString(10, 0, "");
    }
    
}