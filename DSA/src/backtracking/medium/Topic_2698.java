package backtracking.medium;

public class Topic_2698 {

  /**
   * Given a positive integer n, return the punishment number of n.
   * The punishment number of n is defined as the sum of the squares of all integers i such that:
   * 1 <= i <= n
   * The decimal representation of i * i can be partitioned into contiguous substrings such that the sum of the integer values of these substrings equals i.
   * <p>
   * Constraint: 1 <= n <= 1000
   * Solution:
   * The problem requires check different partition of a number so making recursion is natural choice
   * We gonna take the different segmentations ( since the constraint is 1<=n <= 1000 so we choose to take 3 digit only)
   * One digit ( % 10)
   * Two digit( % 100)
   * Three Digit (% 1000)
   */

  public int punishmentNumber(int n) {
    int res = 0;
    for (int i = 1; i <= n; i++) {
      int num = i * i;
      if (isPossible(num, i)) {
        res += num;
      }
    }
    return res;
  }

  private boolean isPossible(int num, int target) {
    if (num < target || target < 0) { // base case
      return false;
    }
    if (num == target) { // base case
      return true;
    }
    boolean isPossibleOneDigit = isPossible(num / 10, target - num % 10);
    boolean isPossibleTwoDigit = isPossible(num / 100, target - num % 100);
    boolean isPossibleThreeDigit = isPossible(num / 1000, target - num % 1000);
    return isPossibleOneDigit || isPossibleTwoDigit || isPossibleThreeDigit;
  }
}
