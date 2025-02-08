package tries.medium;

import java.util.Arrays;

public class Topic_3291_second {


  class TrieNode {
    TrieNode[] nodes;

    TrieNode() {
      nodes = new TrieNode[26];
    }
  }

  class Trie {
    TrieNode root;

    Trie() {
      root = new TrieNode();
    }

    public void addWord(String word) {
      TrieNode current = root;
      for (char c : word.toCharArray()) {
        current = current.nodes[c - 'a'];
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

    int dp[] = new int[n + 1];
    Arrays.fill(dp, INF);
    dp[0] = 0;
    for (int i = 0; i < n; i++) {
      if (dp[i] == INF) { // not valid
        continue;
      }

      TrieNode current = trie.root;
      for (int j = i; j < n; j++) {
        char c = target.charAt(j);
        if (current.nodes[c - 'a'] == null) { // current node doesn't contain the next char
          break;
        }
        current = current.nodes[c - 'a'];
        dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
      }
    }
    return dp[n] == INF ? -1 : dp[n];
  }
}
