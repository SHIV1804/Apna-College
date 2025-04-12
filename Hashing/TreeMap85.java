package Hashing;
import java.util.*;


public class TreeMap85 {

    
    
    public static void main(String[] args) {
        String [] keys  =  {"India", "Japan", "China","United States"};
        Integer [] values = {100,1000,10000,100000};
        TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
        for (int i = 0; i < keys.length; i++) {
            tm.put(keys[i], values[i]);
        }
        System.out.println(tm);
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        for (int i = 0; i < keys.length; i++) {
            hm.put(keys[i], values[i]);
        }
       
        System.out.println(hm);
    }
}