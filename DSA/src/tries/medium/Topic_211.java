package tries.medium;

import java.util.HashMap;
import java.util.Map;

public class Topic_211 {

  /**
   * Design a data structure that supports adding new words and finding if a string matches any previously added string.
   * Implement the WordDictionary class:
   * WordDictionary() Initializes the object.
   * void addWord(word) Adds word to the data structure, it can be matched later.
   * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
   * <p>
   * Solution:
   * Use tries data structure but remember to check if it's fully word added,
   * For example: add(data) then you have a word "data" in your dictionary, not "d","a","t" so search(a) => return false,
   * search(data) => return true
   * We will have a flag to check if it's a "word" and use it as base case in search
   */

  class WordDictionary {
    // 2:23

    class Node {
      char c;
      Map<Character, Node> nodes;
      boolean isWord;

      Node() {
        this.c = '\0';
        nodes = new HashMap<>();
        this.isWord = false;
      }

      Node(char c) {
        this.c = c;
        nodes = new HashMap<>();
        this.isWord = false;
      }

      public Node addNode(char c) {
        return nodes.computeIfAbsent(c, Node::new);
      }
    }

    Node root;

    public WordDictionary() {
      root = new Node();
    }

    public void addWord(String word) {
      Node current = root;
      for (char c : word.toCharArray()) {
        current = current.addNode(c);
      }
      current.isWord = true; // the last character will be true
    }

    public boolean search(String word) {
      return dfs(root, word, 0);
    }

    private boolean dfs(Node current, String word, int index) {
      if (index == word.length()) {
        return current.isWord;
      }
      char c = word.charAt(index);
      if (c == '.') {
        for (Node child : current.nodes.values()) {
          if (dfs(child, word, index + 1)) {
            return true;
          }
        }
        return false;
      } else {
        if (!current.nodes.containsKey(c)) {
          return false;
        }
        return dfs(current.nodes.get(c), word, index + 1);
      }
    }
  }
}
