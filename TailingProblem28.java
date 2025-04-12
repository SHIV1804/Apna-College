import java.util.*;

public class TailingProblem28 {

    static int TailingProblem(int length){
        if (length ==0||length == 1) return 1;
        //vertical
        int vertical = TailingProblem(length-1);
        //horizontal
        int horizontal = TailingProblem(length-2);
        return (vertical+horizontal);
    }
    static void removeDuplicate(String string,int index,StringBuilder sb,boolean[] map){
        if (index == string.length()){ 
            System.out.println(sb);
            return;
        }
        if (map[string.charAt(index)-'a']==false) {
            map[string.charAt(index)-'a']=true;
            sb.append(string.charAt(index));
        }
        removeDuplicate(string,index+1,sb,map);
    }   

    static int friendsPair(int numberOfFriends){
        if (numberOfFriends==1||numberOfFriends==2) {
            return numberOfFriends;
        }
        int totalWays = friendsPair(numberOfFriends-1)+(numberOfFriends-1)*friendsPair(numberOfFriends-2);
        return totalWays;
    }
    public static void main(String[] args) {
        // System.out.println(TailingProblem(5));
        // removeDuplicate("aaaappnacccolllegee", 0,new StringBuilder(),new boolean[26]);
        // System.out.println(friendsPair(4));

    }
}
