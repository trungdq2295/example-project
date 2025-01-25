package sort.medium;

import java.util.*;

public class Topic_2948 {

  /**
   * You are given a 0-indexed array of positive integers nums and a positive integer limit.
   * In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.
   * Return the lexicographically smallest array that can be obtained by performing the operation any number of times.
   * An array a is lexicographically smaller than an array b if in the first position where a and b differ, array a has an element that is less than the corresponding element in b.
   * For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3] because they differ at index 0 and 2 < 10.
   * <p>
   * Solution:
   * The idea is you sort the list based on the limit.
   * First you gonna create an 2d array to store the value and the index of that nums[i]
   * For example: 7,9,8,10,16,15
   * You have a 2d array, {
   * { 7,0 },
   * { 9,1 },
   * { 8,2 },
   * { 10,3 },
   * { 16,4 },
   * { 15,5 },
   * }
   * And then you gonna sort that array based on the value
   * => {
   * { 7,0 },
   * { 8,2 },
   * { 9,1 },
   * { 10,3 },
   * { 15,5 },
   * { 16,4 },
   * }
   * And then  you have to create a set of indices to store the element which is suitable for condition |nums[i]-nums[j]| <= limit
   * => You have 2 set of indices ( since |10-16| > limit) and from 7 to 10, we have middle man as ( 8, 9) to swap these values
   * 1 is 0,2,1,3
   * 2 is 5,4
   * And then you gonna loop through these 2 sets and create new set and sorted them based on the index value => sortedIndex and original set
   * we loop each set and add the index of result based on the value of these two set
   */
  public int[] lexicographicallySmallestArray(int[] nums, int limit) {
    int n = nums.length;
    int[][] nums2 = new int[n][2];
    int[] result = new int[n];
    List<List<Integer>> indices = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      nums2[i][0] = nums[i];
      nums2[i][1] = i;
    }
    Arrays.sort(nums2, Comparator.comparingInt(x -> x[0]));
    for (int i = 0; i < n; i++) {
      if (i == 0 || nums2[i][0] - nums2[i - 1][0] > limit) {
        indices.add(new ArrayList<>());
      }
      indices.get(indices.size() - 1).add(nums2[i][1]);
    }
    for (List<Integer> index : indices) {
      List<Integer> sortedIndex = new ArrayList<>(index);
      Collections.sort(sortedIndex);
      for (int j = 0; j < index.size(); j++) {
        result[sortedIndex.get(j)] = nums[index.get(j)];
      }
    }
    return result;
  }
}
