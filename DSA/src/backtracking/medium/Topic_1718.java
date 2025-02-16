package backtracking.medium;

public class Topic_1718 {

  /**
   * Construct the Lexicographically Largest Valid Sequence
   * <p>
   * Given an integer n, find a sequence that satisfies all of the following:
   * The integer 1 occurs once in the sequence.
   * Each integer between 2 and n occurs twice in the sequence.
   * For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
   * The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.
   * Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.
   * A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ,
   * sequence a has a number greater than the corresponding number in b.
   * For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.
   * <p>
   * Solution:
   * The idea is you need to backtrack the problem ,for each position, you gonna track if with that value "i" which is i <=n, is good to form a valid array
   * If not you have to reset it
   * then how can we do that?
   * At first, we start with the highest value as topic requires
   * For the current index and next index of that num, we gonna put the value into that position and marked it as used
   * And we gonna move to the next position,
   * Everytime, we iterate we need to check if there's number already placed in that position or the num has been already used
   * Until we reach the base case (index == res.length) => valid
   * => if not, then we need to reset the value, for the other num can be processed at that position
   */

  public int[] constructDistancedSequence(int n) {
    int size = n * 2 - 1;
    int[] res = new int[size];
    boolean[] used = new boolean[n + 1];
    backtrack(res, used, 0, n);
    return res;
  }

  private boolean backtrack(int[] res, boolean[] used, int index, int n) {
    while (index < res.length && res[index] != 0) { //move the index to the position which hasn't been processed yet
      index++;
    }
    if (index == res.length) { //base case - valid array
      return true;
    }
    for (int num = n; num >= 1; num--) {
      int secondIndex = index + num;
      // check the num hasn't been processed and also for the secondIndex hasn't been placed by any other num yet
      // num = 1 is a special case, since you can place it anywhere
      if (!used[num] && (num == 1 || (secondIndex < res.length && res[secondIndex] != 0))) {
        res[index] = num;
        if (num > 1) {
          res[secondIndex] = num;
        }
        used[num] = true;
        //process the next to check if with this num, you can form a valid array
        if (backtrack(res, used, index + 1, n)) {
          return true;
        }

        // reset if you can't, so the other num can process
        res[index] = 0;
        if (num > 1) {
          res[secondIndex] = 0;
        }
        used[num] = false;
      }
    }
    return false;
  }
}
