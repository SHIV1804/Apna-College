public class Recursion34 {

    static void printSubstring(String s, int start){
        if (start==s.length()) {
            return;
        }

        // StringBuilder sb = new StringBuilder();
        // for(int i=start; i<s.length(); i++){
        //     sb.append(s.charAt(i));
        //     System.out.println(sb);
        // }
        printSubstring(s, start+1);
    }

    


    public static void main(String[] args) {
        printSubstring("Hello", 0);
    }
}
