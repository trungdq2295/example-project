package backtracking.medium;

public class Topic_DistributeCookie_2305 {

  /**
   * You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag. You are also given an integer k that denotes the number of children to distribute all the bags of cookies to. All the cookies in the same bag must go to the same child and cannot be split up.
   * The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the distribution.
   * Return the minimum unfairness of all distributions.
   * <p>
   * Solution:
   * The idea is to use backtrack the problem by you distribute the cookie to each child and process it
   * Using recursion to distribute the cookie and a temp [] to store the current cookies you have distributed to each children
   * When your recursion reaches to n bags (base case), then you gonna compare which children has the most cookies
   * After, you gonna minus it, and then recursion distribute that bag to other child
   * You keep doing it until you reach the minimum of fairness
   */

  int answer = Integer.MAX_VALUE;

  public int distributeCookies(int[] cookies, int k) {
    helper(cookies, 0, k, new int[k]);
    return answer;
  }

  private void helper(int[] cookies, int start, int k, int[] temp) {
    if (start == cookies.length) {
      int max = 0;
      for (int c : temp) {
        max = Math.max(max, c);
      }
      answer = Math.min(answer, max);
      return;
    }
    for (int i = 0; i < k; i++) {
      temp[i] += cookies[start];
      helper(cookies, start + 1, k, temp);
      temp[i] -= cookies[start];
    }
  }
}
