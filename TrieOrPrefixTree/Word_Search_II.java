package TrieOrPrefixTree;

import java.util.*;

public class Word_Search_II {

    static List<String> ll = new ArrayList<>();

    public static class Trie {

        class Node {
            char ch;
            String word;   // store complete word instead of boolean
            HashMap<Character, Node> child;

            public Node(char ch) {
                this.ch = ch;
                child = new HashMap<>();
            }
        }

        public Node root;

        public Trie() {
            root = new Node('*');
        }

        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!curr.child.containsKey(ch)) {
                    curr.child.put(ch, new Node(ch));
                }
                curr = curr.child.get(ch);
            }
            curr.word = word;
        }

        public void Search(char[][] maze, int i, int j, Node node) {

            if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length)
                return;

            char ch = maze[i][j];

            if (ch == '#' || !node.child.containsKey(ch))
                return;

            node = node.child.get(ch);

            if (node.word != null) {
                ll.add(node.word);
                node.word = null; // avoid duplicate
            }

            maze[i][j] = '#'; // mark visited

            Search(maze, i + 1, j, node);
            Search(maze, i - 1, j, node);
            Search(maze, i, j + 1, node);
            Search(maze, i, j - 1, node);

            maze[i][j] = ch; // restore
        }
    }

    public static void main(String[] args) {

        char[][] maze = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        String[] words = {"oath","pea","eat","rain"};

        Trie t = new Trie();

        for (String s : words) {
            t.insert(s);
        }

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (t.root.child.containsKey(maze[i][j])) {
                    t.Search(maze, i, j, t.root);
                }
            }
        }

        System.out.println(ll);
    }
}
