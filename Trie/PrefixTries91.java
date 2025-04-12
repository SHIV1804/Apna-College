
package Trie;

import java.util.*;

/**
 * PrefixTries91
 */
public class PrefixTries91 {
    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;
        int frequency;
        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node();
    // Inserting data in tree

    static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int indexOfChar = word.charAt(i) - 'a';
            if (curr.children[indexOfChar] == null) {
                curr.children[indexOfChar] = new Node();
                curr.children[indexOfChar].frequency =1;
            }else{
                curr.children[indexOfChar].frequency++;
            }
            curr = curr.children[indexOfChar];
        }
        curr.endOfWord = true;
    }
    //approach 1
    static String searchWordPrefix(String key) {
        StringBuilder stringBuilder = new StringBuilder();
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            stringBuilder.append(key.charAt(i));
            if (curr.children[index].frequency == 1) {
                return stringBuilder.toString();
            }
            curr = curr.children[index];
        }
        return stringBuilder.toString();
    }

    public static void uniquePrefixApproach1(String[] word) {
        String prefix[] = new String[word.length];

        for (int i = 0; i < word.length; i++) {
            prefix[i] = searchWordPrefix(word[i]);
        }
        System.out.println();
        for (String string : prefix) {
            System.out.print(string+" ");
        }
        System.out.println();
    }


    public static void uniquePrefixApproach2(Node root,String prefix) {
        if(root == null) return;
        if(root.frequency==1){ System.out.println(prefix);return;}

        for (int i = 0; i < 26; i++) {
            if(root.children[i]!=null){
                uniquePrefixApproach2(root.children[i],(prefix+(char)(i+'a')) );
            }
        }
    }

    public static boolean startsWith(String prefix){
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i)-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }


    

    public static void main(String[] args) {
        String words [] = {"there","their","any","thee"};
        for (String string : words) {
            insert(string);
        }
        uniquePrefixApproach1(words);
        uniquePrefixApproach2(root, "");

        System.out.println();
        System.out.println();
        System.out.println(startsWith("the"));
        System.out.println(startsWith("and"));
    }
}