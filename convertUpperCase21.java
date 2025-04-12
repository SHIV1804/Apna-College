public class convertUpperCase21 {

    static String convertUpperCase(String string){
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(string.charAt(0)));
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                sb.append(string.charAt(i));
                i++;
                sb.append(Character.toUpperCase(string.charAt(i)));
            }else{
               sb.append(string.charAt(i)); 
            }
            
        }
        return sb.toString();
    }

    static void stringCompression(String string){
        StringBuilder sb = new StringBuilder("");
        int count=1;
        Character ch = string.charAt(0);
        
        for (int i = 1; i < string.length(); i++) {
            if (ch==string.charAt(i)) {
                count++;
            }
            else{

                if (count==1) {
                    sb.append(ch);
                }else{
                    sb.append(ch+""+count);
                }
                count=1;
            }
            ch=string.charAt(i);
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        // String string = "hi , i am shivam.";
        
        // System.out.println(convertUpperCase(string));

        String string = "aaaaabbbbbbcdddddeeeeeefffffggggghiiiiiiijjjjj";
        stringCompression(string);
    }
}
