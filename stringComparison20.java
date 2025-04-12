public class stringComparison20 {

    public static void main(String[] args) {
        String string[] = {"aaabcd", "aaabcs", "aabbcp", "aaabcq"};
        String largest = string[0];
        for (int i = 0; i < string.length; i++) {
            if (largest.compareTo(string[i]) < 0) {
                largest= string[i];
            }
        }
        System.out.println(largest);
    }
}
