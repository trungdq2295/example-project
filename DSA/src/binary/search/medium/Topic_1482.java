package binary.search.medium;

import java.util.Arrays;

public class Topic_1482 {

  /**
   * You are given an integer array bloomDay, an integer m and an integer k.
   * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
   * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
   * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
   * <p>
   * Solution: You notice the topic mention about day which is going from day 1 to day n
   * => Use the binary search
   * The idea is you gonna get the highest day in the bloomDay as a right, and first day as left
   * You calculate mid and then you use mid to check with that day, will we get enough bouquets
   */
  public int minDays(int[] bloomDay, int m, int k) {
    int n = bloomDay.length;
    if (n < m * k) { // higher flower than we have
      return -1;
    }
    int left = 1;
    int right = Arrays.stream(bloomDay).max().getAsInt();
    int result = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (canMakeBouquet(bloomDay, m, k, mid)) {
        result = mid;
        right = mid - 1; // keep moving until we get smaller element;
      } else {
        left = mid + 1;
      }
    }
    return result;
  }

  private boolean canMakeBouquet(int[] bloomDay, int m, int k, int day) {
    int flower = 0;
    int bouquet = 0;
    for (int num : bloomDay) {
      if (num <= day) {
        flower++;
        if (flower == k) {
          bouquet++;
          flower = 0;
        }
      } else {
        flower = 0;
      }
      if (bouquet >= m) {
        return true;
      }
    }
    return bouquet >= m;
  }

}
