package ArrayList;

import java.util.*;

public class ArrayList43 {
    
    public static void basic(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        list.set(0, 10);
        list.add(0,100);
        list.remove(1);
        System.out.println(list.contains(2));
        System.out.println(list.size());
        Collections.sort(list);
        System.out.println(list);

        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        mainlist.add(nums);
        mainlist.add(list);
        for (int i = 0; i < mainlist.size(); i++) {
            ArrayList<Integer> currList = mainlist.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        basic();
    }
}
