package greedy.hard;

import java.util.LinkedList;
import java.util.Queue;

public class Topic_1585 {


  /**
   * Check If String Is Transformable With Substring Sort Operations
   * <p>
   * Given two strings s and t, transform string s into string t using the following operation any number of times:
   * Choose a non-empty substring in s and sort it in place so the characters are in ascending order.
   * For example, applying the operation on the underlined substring in "14234" results in "12344".
   * Return true if it is possible to transform s into t. Otherwise, return false.
   * A substring is a contiguous sequence of characters within a string.
   * <p>
   * Solution:
   * The idea is you need to track that require character at "i" of t:
   * + Should be existed in s
   * + And if you want to move that character in s, then you have to ensure that there's no lesser digit stand before that character
   */

  public boolean isTransformable(String s, String t) {
    Queue<Integer>[] pos = new Queue[10];
    for (int i = 0; i < 10; i++) {
      pos[i] = new LinkedList<>();
    }

    for (int i = 0; i < s.length(); i++) {
      pos[s.charAt(i) - '0'].offer(i); // Store the index of the digit in s
    }

    for (char c : t.toCharArray()) {
      int digit = c - '0';
      if (pos[digit].isEmpty()) { // This  mean s doesn't contains that digit in any index
        return false;
      }

      int index = pos[digit].poll();

      // We need to make sure, there's no lesser digit stand before the current index
      for (int d = 0; d < digit; d++) {
        if (!pos[d].isEmpty() && pos[d].peek() < index) {
          return false;
        }
      }
    }
    return true;
  }

  // TLE
  public boolean isTransformable2(String s, String t) {
    char[] charsS = s.toCharArray();
    char[] charsT = t.toCharArray();
    int n = charsS.length;
    for (int i = 0; i < n; i++) {
      if (charsS[i] != charsT[i]) {
        int j = i;
        while (j < n) {
          if (charsS[j] == charsT[i]) {
            break;
          }
          j++;
        }
        if (j == n || charsS[j] > charsS[i]) { // no valid
          return false;
        }

        for (int z = j; z > i; z--) {
          if (charsS[z] > charsS[z - 1]) {
            return false;
          }
          char temp = charsS[z];
          charsS[z] = charsS[z - 1];
          charsS[z - 1] = temp;
        }
      }
    }
    return true;
  }
}
