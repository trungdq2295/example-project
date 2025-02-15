package dynamic.programming.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Topic_2707 {

  /**
   * You are given a 0-indexed string s and a dictionary of words dictionary.
   * You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary.
   * There may be some extra characters in s which are not present in any of the substrings.
   * Return the minimum number of extra characters left over if you break up s optimally.
   * <p>
   * Solution: We gonna use dp with length of dp equals to length of string s
   * Because we wanna track in each word with length from s[0]..s[n], is there a way to remove all the substring by using word in dictionary
   * For the fast tracking word in dictionary, we gonna convert it to set => O(1) lookup
   */
  public int minExtraChar(String s, String[] dictionary) {
    Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 0; // empty string => result at 0
    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1] + 1; // add extra character to the current string
      for (int j = 0; j < i; j++) {
        String substring = s.substring(j, i);
        /**
         * We gonna check if the substring in the current string can be range from 0..j..i-1 can be removed by word in dictionary
         * Example: leetscode and dictonary = [leet,code]
         * When it start at 0 => 0 character
         * 1 => 1, 2=>2, 3=>3
         * until we reach 4, we see that we can use dictionary[0] to remove the current string "leet" => dp[4] = Math.min(dp[4], dp[0]) = min(4, 0) = 0
         *
         */
        if (dict.contains(substring)) {
          dp[i] = Math.min(dp[i], dp[j]);
        }
      }
    }
    return dp[n];
  }
}
