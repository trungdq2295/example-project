package bit.manipulation.medium;

public class Topic_1017 {


  /**
   * Convert to Base -2
   * Given an integer n, return a binary string representing its representation in base -2.
   * Note that the returned string should not have leading zeros unless the string is "0".
   * <p>
   * Solution:
   * The same when you convetr to base 2
   * It just everytime you shift to the right, you need to multiply for -1 too
   * Because in base-2, sometime it can be negative in base 10
   */
  public String baseNeg2(int n) {
    if (n == 0) { // edge case
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    // first way
    /**
     * while(n != 0){
     * int remaining = n % (-2); // since we % (-2), there's a case remianing can be
     * < 0
     * n /= -2;
     * if(remaining < 0){ // We need to adjust the case remaining < 0
     * remaining +=2;
     * n++; // The reason we +1 because we let the remaining + 2, we borrow from the
     * n, 1 bit
     * }
     * sb.append(remaining);
     * }
     */
    // Second way
    while (n != 0) {
      sb.append(n & 1); // take the last bit of n
      n = -(n >> 1); // divide by 2 and then multiple to (-2)
    }
    return sb.reverse().toString();
  }
}
