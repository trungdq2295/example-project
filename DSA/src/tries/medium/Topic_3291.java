package tries.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Topic_3291 {

  /**
   * You are given an array of strings words and a string target.
   * <p>
   * A string x is called valid if x is a prefix of any string in words.
   * Return the minimum number of valid strings that can be concatenated to form target.
   * <p>
   * If it is not possible to form target, return -1.
   * <p>
   * Solution:
   * it mentions using prefix of character => think about Trie
   * => Build Trie
   * and using dp to track the minimum step to build each character from 0 to n in target
   */


  class Node {
    char c;
    Map<Character, Node> nodes;

    Node() {
      c = '\0';
      nodes = new HashMap<>();
    }

    Node(char c) {
      this.c = c;
      nodes = new HashMap<>();
    }
  }


  class Trie {
    Node root;

    Trie() {
      root = new Node();
    }

    public void addWord(String word) {
      Node current = root;
      for (char c : word.toCharArray()) {
        current = current.nodes.computeIfAbsent(c, k -> new Node());
      }
    }
  }

  public int minValidStrings(String[] words, String target) {
    int n = target.length();
    int INF = Integer.MAX_VALUE / 2;

    Trie trie = new Trie();
    for (String word : words) {
      trie.addWord(word);
    }


    int[] dp = new int[n + 1];
    Arrays.fill(dp, INF);
    dp[0] = 0; // 0 at 0-index character
    for (int i = 0; i < n; i++) {
      if (dp[i] == INF) {
        continue;
      }

      Node current = trie.root;
      for (int j = i; j < n; j++) {
        char c = target.charAt(j);
        if (!current.nodes.containsKey(c)) { // invalid character at trie
          break;
        }
        current = current.nodes.get(c);
        dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
      }
    }
    return dp[n] == INF ? -1 : dp[n];
  }


}
