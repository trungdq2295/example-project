package binary.search.medium;

public class Topic_300 {


  /**
   * Given an integer array nums, return the length of the longest strictly increasing subsequence
   * Solution:
   * To use Binary search, to determine an array which can store the ordered element
   * The idea is in every num in array, we gonna track if the number can be stored in our new array which is strictly ordered increasing
   */

  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int size = 0; // track the number of elements in tails array
    int[] tails = new int[n]; // new array to store number in ascending order
    for (int num : nums) {
      // Use binary search to find the position of `num` in the tails array
      int left = 0;
      int right = size;
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (tails[mid] < num) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      if (left == size) { // this mean the number is greater than all element in tails, we need to extend the size
        tails[size] = num;
        size++;
      } else { // Replace the first element in tails that is which is >= num
        tails[left] = num;
      }
    }
    return size;
  }
}
