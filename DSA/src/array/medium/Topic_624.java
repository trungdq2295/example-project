package array.medium;

import java.util.List;

public class Topic_624 {

  /**
   * You are given m arrays, where each array is sorted in ascending order.
   * You can pick up two integers from two different arrays (each array picks one) and calculate the distance.
   * We define the distance between two integers a and b to be their absolute difference |a - b|.
   * Return the maximum distance
   * <p>
   * Solution:
   * The idea to track the current max, min and calculate it by using the min/max from current index
   * So first, we start with first index of array with min value = array.get(0).get(0) and max = value.get(0).get(value.get(0).size() - 1);
   * and then we start to iterate from index 1 until the end
   */
  public int maxDistance(List<List<Integer>> arrays) {
    int min = arrays.get(0).get(0);
    int max = arrays.get(0).get(arrays.get(0).size() - 1);
    int maxDistance = 0;
    for (int i = 1; i < arrays.size(); i++) {
      int currentMin = arrays.get(i).get(0);
      int currentMax = arrays.get(i).get(arrays.get(i).size() - 1);

      // Start to check
      maxDistance = Math.max(maxDistance, currentMax - min);
      maxDistance = Math.max(maxDistance, max - currentMin);

      //update the current min/max for the next value to check
      min = Math.min(min, currentMin);
      max = Math.max(max, currentMax);
    }

    return maxDistance;
  }
}
