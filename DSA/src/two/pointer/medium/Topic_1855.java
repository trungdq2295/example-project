package two.pointer.medium;

public class Topic_1855 {

  /**
   * You are given two non-increasing 0-indexed integer arrays nums1 and nums2
   * A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length, is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i
   * Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.
   * An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.
   * <p>
   * Solution:
   * Since both array is sorted descending, we gonna use two pointer for each array: pointer i for nums1 and pointer j for nums2
   * We gonna check at each element of pointer
   * if nums1[i] <= nums2[j] =>  we calculate the distance between j and i and the moving the pointer j until nums2[j] no longer greater than or equals nums1[i]
   * => we move pointer i to find the number nums1[i] less than current nums2[j]
   */
  public int maxDistance(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int max = 0;
    int i = 0;
    int j = 0;
    while (i < n && j < m) {
      if (nums1[i] <= nums2[j]) {
        max = Math.max(max, j - i);
        j++;
      } else {
        i++;
      }
    }
    return max;
  }
}
