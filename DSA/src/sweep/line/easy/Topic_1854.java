package sweep.line.easy;

public class Topic_1854 {

  /**
   * Maximum Population Year
   *
   * You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
   * The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
   * Return the earliest year with the maximum population.
   *
   * Solution: Sweepline dude
   *  We create an array to store the year
   *  And then We gonna track the number of population in each year
   *    + +1 for logs[0] ~= birth year
   *    + -1 for logs[1] <=> death year
   *  After that, we gonna iterate the year array to compare
   *    + If the number of population greater than the previous year, update the max year
   *    + If not, keep iterate
   */
  public int maximumPopulation(int[][] logs) {
    int[] year = new int[2051];//constraint
    for(int[] log: logs){
      year[log[0]] += 1;
      year[log[1]] -= 1;
    }

    int maxNum = year[1950];
    int maxYear = 1950;

    for(int i = 1951; i <year.length;i++){
      year[i] += year[i-1];
      if(year[i] > maxNum){
        maxNum = year[i];
        maxYear = i;
      }
    }
    return maxYear;
  }
}
