package BackTracking;

public class printCharacterOfKeys42 {
    static char character[][] = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v', 'w' }, { 'x', 'y', 'z' } };

    public static void printCharacterOfKeys(String string, int position,int end,StringBuilder sb) {
        if (position == end) {
            System.out.println(sb);
        }
        else {
            char length [] = character[Character.getNumericValue(string.charAt(position))];
            for (int j = 0; j < length.length ; j++) {

            printCharacterOfKeys(string, position + 1, end,new StringBuilder(sb).append(length[j]));
            }
            
        }
    }

    public static void main(String[] args) {
        printCharacterOfKeys("23", 0, 2, new StringBuilder());
    }
    
}
