package dynamic.programming.easy;

public class Topic_70 {

  /**
   * You are climbing a staircase. It takes n steps to reach the top.
   * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
   * <p>
   * Solution:
   * You start at step n and then recursion till the bottom ( base case: n =0 => it 's at the start index then return 1, if n < 0, then return 0 since it's not start point)
   */
  public int climbStairs(int n) {
    return countStep(n, new int[n + 1]);
  }

  private int countStep(int n, int[] mem) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    if (mem[n] != 0) {
      return mem[n];
    }
    mem[n] = countStep(n - 1, mem) + countStep(n - 2, mem);
    return mem[n];
  }

}
