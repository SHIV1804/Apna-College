

public class BacktrackingPermutation37 {

    public static void permutationOfString(String string,String answer) {
        if (string.length()==0) {
            System.out.println(answer);
            return;
        }
        for (int i = 0; i < string.length(); i++) {
            char currChar = string.charAt(i);
            String newString = string.substring(0, i)+string.substring(i+1);
            permutationOfString(newString, answer+currChar);
        }
    }


    public static void main(String[] args) {
        permutationOfString("wxyz", "");
    }
}
