
public class assignment22 {
    static void numberOfVowels(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {

            switch (string.charAt(i)) {
                case 'a':

                    count++;
                    break;
                case 'e':

                    count++;
                    break;
                case 'i':

                    count++;
                    break;
                case 'o':

                    count++;
                    break;
                case 'u':

                    count++;
                    break;
            }

        }

        System.out.println("Number of lowercase vowels: " + count);
    }

    static void anargram(String string1, String string2) {
        int length1 = string1.length();
        int length2 = string2.length();
        int i=0;
        boolean flag = false;

        if (length1 == length2) {
            for (; i < length1; i++) {
                for (int j = 0; j < length2; j++) {
                    if (string1.charAt(i) == string2.charAt(j)) {
                        if (j < string2.length() - 1)
                            string2 = string2.substring(0, j) + (string2.substring(j + 1, length1));
                        else
                            string2 = string2.substring(0, j);

                        flag = true;
                        System.out.println("Break");
                        break;
                    } else
                        flag = false;

                }
                if (flag == false) {
                    break;
                }
            }
        }
        if (i == length1) {
            System.out.println("Strings are anargram.");
        } else {
            System.out.println("Strings are not anargram.");
        }
    }

    public static void main(String[] args) {
        // String string = "Hi , I am Shivam.";
        // numberOfVowels(string);
        String string1 = "aaam", string2 = "maa";
        anargram(string1, string2);
        
    }
}
