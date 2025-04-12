package Trie;

import java.util.*;


public class Tries90 {
    //Creating node class 
    static class Node{
        Node children[] = new Node[26];
        boolean endOfWord=false;
        Node(){
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }
    static Node root = new Node();
    //Inserting data in tree

    static void insert(String word){
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int indexOfChar = word.charAt(i)-'a';
            if (curr.children[indexOfChar]==null) {
                curr.children[indexOfChar] = new Node();
            }
            curr = curr.children[indexOfChar];
        }
        curr.endOfWord = true;
    }

    static boolean searchWord(String key){
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i)-'a';
            if (curr.children[index] ==null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.endOfWord==true;
    }


    
    

    public static void main(String[] args) {
        String words [] = {"the","a","there","their","any","thee"};
        for (String string : words) {
            insert(string);
        }
        System.out.println(searchWord("thee"));
        System.out.println(searchWord("thor"));
    }
}