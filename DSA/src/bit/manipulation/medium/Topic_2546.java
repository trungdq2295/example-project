package bit.manipulation.medium;

public class Topic_2546 {

  /**
   * You are given two 0-indexed binary strings s and target of the same length n. You can do the following operation on s any number of times:
   * Choose two different indices i and j where 0 <= i, j < n.
   * Simultaneously, replace s[i] with (s[i] OR s[j]) and s[j] with (s[i] XOR s[j]).
   * For example, if s = "0110", you can choose i = 0 and j = 2, then simultaneously replace s[0] with (s[0] OR s[2] = 0 OR 1 = 1), and s[2] with (s[0] XOR s[2] = 0 XOR 1 = 1), so we will have s = "1110".
   * Return true if you can make the string s equal to target, or false otherwise.
   *
   * Solution:
   *  The enumeration: both XOR and OR
   *   00 -> 00
   *   01 -> 11
   *   10 -> 11
   *   11 -> 10
   *  This mean two "0" stay 0,
   *  If you have  "1", you can make any to 0 or 1
   *  If you have at least "1", you can make any 1 to 0
   */
}
