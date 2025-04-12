

package Hashing;
import java.util.*;


public class LinkedHashMap84 {

    
    
    public static void main(String[] args) {
        String [] keys  =  {"India", "Japan", "China","United States"};
        Integer [] values = {100,1000,10000,100000};
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<String,Integer>();
        for (int i = 0; i < keys.length; i++) {
            lhm.put(keys[i], values[i]);
        }
        System.out.println(lhm);
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        for (int i = 0; i < keys.length; i++) {
            hm.put(keys[i], values[i]);
        }
        System.out.println(hm);
    }
}