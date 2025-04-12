

package Trie;
import java.util.*;
/**
 * Tries92
 */
public class Tries92 {

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


    public static int countNodes(Node root){
        if (root==null) {
            return 0;
        }
        int count=0;
        for (int i = 0; i < 26; i++) {
            if(root.children[i]!=null) 
                count+=countNodes(root.children[i]);
        }
        return count+1;
    }


    public static void main(String[] args) {
        String string = "apple";
        //all suffix;
        for (int i = 0; i < string.length(); i++) {
            insert(string.substring(i));
        }
       System.out.println(countNodes(root));
    }
    
}