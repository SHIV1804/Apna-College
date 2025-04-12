package Hashing;
import java.util.*;


public class HashMap86 {

    static void majorityElments(int nums[]){
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        Set<Integer> temp = map.keySet();
        int length = nums.length/3;
        for (Integer integer : temp) {
            if(map.get(integer)>length) System.out.print(integer+" ");
        }
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            if (map.containsKey(temp)) {
                int val = map.get(temp);
                if (val == 0) {
                    map.remove(temp);
                    continue;
                }
                map.put(temp, map.get(temp) - 1);

            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int nums [] = {1,2,3,4,1,1,1,1,1};
        majorityElments(nums);
        System.out.println();
        System.out.println(isAnagram("anagram", "nagaram"));
        
    }
}