package bit.manipulation.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Topic_1073 {

  /**
   * Adding Two Negabinary Numbers
   * <p>
   * Given two numbers arr1 and arr2 in base -2, return the result of adding them together.
   * Each number is given in array format:  as an array of 0s and 1s, from most significant bit to least significant bit.
   * For example, arr = [1,1,0,1] represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.
   * A number arr in array, format is also guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.
   * Return the result of adding arr1 and arr2 in the same format: as an array of 0s and 1s with no leading zeros.
   * <p>
   * Solution:
   * Take it easy. Think as how you can do this with base 2, and then it's the same for base -2, it's just you need to adjust the carry by multiplying -1
   */

  public int[] addBinary(int[] arr1, int[] arr2) {
    List<Integer> res = new ArrayList<>();
    int carry = 0, i = arr1.length - 1, j = arr2.length - 1;
    while (i >= 0 || j >= 0 || carry != 0) { // the good way to iterate both array with have different length
      if (i >= 0) {
        carry += arr1[i--];
      }
      if (j >= 0) {
        carry += arr2[j--];
      }
      res.add(carry & 1); // take the last set
      carry = carry >> 1;
    }
    Collections.reverse(res);
    return res.stream().mapToInt(Integer::intValue).toArray();
  }

  public int[] addNegabinary(int[] arr1, int[] arr2) {
    List<Integer> res = new ArrayList<>();
    int carry = 0, i = arr1.length - 1, j = arr2.length - 1;
    while (i >= 0 || j >= 0 || carry != 0) {
      if (i >= 0) {
        carry += arr1[i];
        i--;
      }
      if (j >= 0) {
        carry += arr2[j];
        j--;
      }
      res.add(carry & 1); // this equals to carry % 2
      carry = -(carry >> 1); //negabinary calculation
    }
    while (res.size() > 1 && res.get(res.size() - 1) == 0) { // remove leading zeros;
      res.remove(res.size() - 1);
    }
    Collections.reverse(res);
    return res.stream().mapToInt(Integer::intValue).toArray();
  }
}
