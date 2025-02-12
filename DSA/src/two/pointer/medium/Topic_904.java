package two.pointer.medium;

import java.util.HashMap;
import java.util.Map;

public class Topic_904 {

  /**
   * You are visiting a farm that has a single row of fruit trees arranged from left to right.
   * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
   * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
   * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
   * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
   * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
   * Given the integer array fruits, return the maximum number of fruits you can pick.
   * <p>
   * Solution:
   * To use hashmap to store the count of fruit[i] and 2 pointer left and right
   * + Right is to iterate to count the fruit[right] and in each loop, we gonna check if the map is larger than 2 ( more than 2 type of fruit)
   * => start to move left at 0 and decrement the count of fruit[left] until the fruit's count is 0 and then we remove it
   * finally, we calculate the max and right - left + 1 (inclusive)
   */

  public int totalFruit(int[] fruits) {
    int n = fruits.length;
    int res = 0;
    Map<Integer, Integer> count = new HashMap<>();
    for (int l = 0, r = 0; r < n; r++) {
      count.put(fruits[r], count.getOrDefault(fruits[r], 0) + 1);
      while (count.size() > 2) {
        //decrement from the left
        count.put(fruits[l], count.get(fruits[l]) - 1);
        // remove the key which has 0 value
        count.remove(fruits[l], 0);
        l++;
      }
      res = Math.max(res, r - l + 1);
    }
    return res;

  }
}
