package TrieOrPrefixTree;
import java.util.*;

public class replace_word {

    public static void main(String[] args) {

        String[] Dictionary = {"cat","bat","rat"};

        Trie t = new Trie();
        for(String s : Dictionary) {
            t.insert(s);
        }

        String sentence = "the cattle was rattled by battery";
        String[] arr = sentence.split(" ");

        StringBuilder sb = new StringBuilder();

        // ✅ FIX HERE
        for(int i = 0; i < arr.length; i++) {
            String get = t.search(arr[i]);
            sb.append(get).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static class Trie {

        class Node {
            String isTerminal;
            HashMap<Character, Node> child = new HashMap<>();
        }

        private Node root = new Node();

        public void insert(String word) {
            Node curr = root;
            for(char ch : word.toCharArray()) {
                curr.child.putIfAbsent(ch, new Node());
                curr = curr.child.get(ch);
            }
            curr.isTerminal = word;
        }

        public String search(String word) {
            Node curr = root;
            for(char ch : word.toCharArray()) {
                if(!curr.child.containsKey(ch))
                    return word;

                curr = curr.child.get(ch);

                if(curr.isTerminal != null)
                    return curr.isTerminal;
            }
            return word;
        }
    }
}
