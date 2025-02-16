package heap.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Topic_3362 {

  /**
   * Zero Array Transformation III
   * <p>
   * You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri].
   * Each queries[i] represents the following action on nums:
   * Decrement the value at each index in the range [li, ri] in nums by at most 1.
   * The amount by which the value is decremented can be chosen independently for each index.
   * A Zero Array is an array with all its elements equal to 0.
   * Return the maximum number of elements that can be removed from queries,
   * such that nums can still be converted to a zero array using the remaining queries. If it is not possible to convert nums to a zero array, return -1.
   * <p>
   * <p>
   * Solution:
   * First we gonna sort the queries, so we can process in the other
   * And then, we init an array end[n + 1] to store the queries that end at position i
   * Take the queries with the biggest ending index
   * Use a max heap to store ending index, so we can always get the highest ending index from queries[]
   * <p>
   * We gonna start to iterate
   * In each iteration, we decrease the "current" count by the number of queries that end at position i ex: current -= end[i];
   * And then, we check if there's still queries which has ending lesser or equal to the current[i]
   * And then, we gonna check current and nums[i] this to ensure we can decrease the value of num[i] to 0
   */
  public int maxRemoval(int[] nums, int[][] queries) {
    int n = nums.length;
    int m = queries.length;
    Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
    int[] end = new int[n + 1];
    int current = 0,  //are number of queries currently in use.
      j = 0; // pointer for queries
    for (int i = 0; i < n; i++) {
      current -= end[i];
      while (j < m && queries[j][0] <= i) { // loop until we get the beginning index greater than current i
        heap.offer(queries[j][1]); // we greedily to pick the furthest ending index to minimize the query usage
        j++;
      }
      while (current < nums[i]) { // check this to make sure how many step we need to decrement the nums[i] to 0
        if (heap.isEmpty() || heap.peek() < i) {
          return -1;
        }
        end[heap.poll() + 1]++;
        current++;
      }
    }
    return heap.size();
  }
}
