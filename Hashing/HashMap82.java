package Hashing;

import java.util.*;
import java.util.Map.Entry;


public class HashMap82 {

    


    public static void main(String[] args) {
        
        HashMap <String,Integer> hm = new HashMap<>();
        hm.put("India",100000);
        hm.put("China", 1000);
        hm.put("Japan",10);
        // System.out.println(hm);
        // System.out.println(hm.size());
        // System.out.println(hm.containsKey("China"));
        // System.out.println(hm.isEmpty());
        // System.out.println(hm.remove("China"));
        // hm.clear();
        // System.out.println(hm.isEmpty());

        Set<String> set = hm.keySet();
        for (String string : set) {
            System.out.println("Key : " + string + "     Value : " + hm.get(string));
        }
        Set<Entry<String, Integer>> pairSet = hm.entrySet();
        for (Entry<String,Integer> entry : pairSet) {
            System.out.println(entry);
        }
    }   
}