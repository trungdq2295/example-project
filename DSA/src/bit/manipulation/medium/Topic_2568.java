package bit.manipulation.medium;

import java.util.HashSet;
import java.util.Set;

public class Topic_2568 {

  /**
   * Minimum Impossible OR
   * You are given a 0-indexed integer array nums.
   * We say that an integer x is expressible from nums if there exist some integers 0 <= index1 < index2 < ... < indexk < nums.length
   * for which nums[index1] | nums[index2] | ... | nums[indexk] = x.
   * In other words, an integer is expressible if it can be written as the bitwise OR of some subsequence of nums.
   * Return the minimum positive non-zero integer that is not expressible from nums.
   * <p>
   * Solution:
   * If we have 1 and 2, we can have 3 since 1 | 2 =3
   * => If we don't have 1 and 2, we cant make 3
   * If we have 1,2 and 4, we can return 5 ( 1 | 4), 6 ( 2|4), 7(1|2|4),
   * => if we don't have 4, we cant make 5, 6, 7
   * So the idea here is to check if the array contains the number which is power of 2 from 0 to n
   */

  public int minImpossibleOR(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int a = 1;
    while (set.contains(a)) {
      a = a << 1;
    }
    return a;
  }
}
