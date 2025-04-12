package Hashing;
import java.util.*;

public class Sets87{

    
    
    public static void main(String[] args) {
        //HashSet
        HashSet<Integer> set = new HashSet<>();
        int temp [] = {1,2,3,4,5,1,2,34};
        for (int i = 0; i < temp.length; i++) {
         set.add(temp[i]);   
        }
        System.out.println(set.contains(1));
        System.out.println(set.size());
        System.out.println(set.remove(5));
        // set.clear();
        System.out.println(set.isEmpty());
        // Interation over HashSet
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+"  ");
        }

        // LinkedHashSet
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(3);
        lhs.add(4);
        lhs.add(1);
        lhs.add(2);
        
        System.out.println();
        System.out.println(lhs);
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(3);
        ts.add(4);
        ts.add(1);
        ts.add(2);
       
        System.out.println(ts);
    }
}