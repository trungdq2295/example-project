package bit.manipulation.medium;

public class Topic_2680 {


  /**
   * Maximum OR
   * You are given a 0-indexed integer array nums of length n and an integer k. In an operation, you can choose an element and multiply it by 2.
   * Return the maximum possible value of nums[0] | nums[1] | ... | nums[n - 1] that can be obtained after applying the operation on nums at most k times.
   * Note that a | b denotes the bitwise or between two integers a and b.
   *
   * Solution:
   *  For a | b to reach highest is when a or b has the most left set bit
   *  Operation multiply by 2 is equals shift the bit to left by 1
   *  => Most optimal way is to perform all operation on single number
   *  => we gonna perform on each element to get the highest possible
   *  And the idea is to store prefix sum of "OR" before the index "i" and suffix sum after the index "i"
   *  so when you loop, you only need to calculate OR prefix[i] | (nums[i] << k) | sufix[i]
   *  This is better than you calculate all the nums and then minus the nums[i] and then calculate again
   */

  public long maximumOr(int[] nums, int k) {
    long res = 0;
    int n = nums.length;
    long[] prefix = new long[n + 1];
    long[] suffix = new long[n + 1];
    for (int i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] | nums[i];
      suffix[n-1-i] = suffix[n-i] | nums[n-1-i];
    }
//    for(int i = n - 1; i >=0 ;i--){
//      suffix[i] = suffix[i+1] | nums[i];
//    }

    for(int i = 0; i<n;i++){
      long modified = (long) nums[i] << k; // this euqls to nums[i] * Math.pow(2,k);
      long currentOr = prefix[i] | modified | suffix[i+1];
      res = Math.max(currentOr, res);
    }

    return res;
  }
}
