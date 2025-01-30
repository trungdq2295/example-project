package bit.manipulation.medium;

import java.util.ArrayList;
import java.util.List;

public class Topic_1177 {

  /**
   * You are given a string s and array queries where queries[i] = [lefti, righti, ki].
   * We may rearrange the substring s[lefti...righti] for each query and then choose up to ki of them to replace with any lowercase English letter.
   * If the substring is possible to be a palindrome string after the operations above, the result of the query is true. Otherwise, the result is false.
   * <p>
   * Return a boolean array answer where answer[i] is the result of the ith query queries[i].
   * <p>
   * Note that each letter is counted individually for replacement, so if, for example s[lefti...righti] = "aaa", and ki = 2,
   * we can only replace two of the letters. Also, note that no query modifies the initial string s. but you can swap the character in the substring
   * <p>
   * Solution:
   * since the even character is good for palindrome so the idea is you count the odd character in sub string.
   * If you have only 1 odd character and your sub string's length is odd. That's good
   * However, if you have more than 1 odd character, you need to replace 1 odd character to make it even
   * Example: "aaabbb" => you gonna replace "a" to "b"( or in constract b to a) and change the order => bbaabb
   * => count[a] + count[b] = - even number =>  Each replacement can fix 2 odd character => you gonna check oddCount/2 <= k with k is the maximum character you can replace
   * <p>
   * However, for every queries, you gonna count the frequency of each character, this gonna be ineffcient
   * We will use prefixCount to store the odds count by using bitwise ^(OR) since x ^ x = 0 ( this mean you have even count of character)
   */

  public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
    List<Boolean> res = new ArrayList<>();
    int n = s.length();
    int[] prefix = new int[n + 1];
    for (int i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] ^ (1 << (s.charAt(i) - 'a'));
    }

    for (int[] q : queries) {
      int left = q[0], right = q[1], k = q[2];
      int oddCount = Integer.bitCount(prefix[right + 1] ^ prefix[left]);
      res.add(oddCount / 2 <= k);
    }

    return res;

  }
}
