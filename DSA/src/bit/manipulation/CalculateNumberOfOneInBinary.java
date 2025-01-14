package bit.manipulation;

public class CalculateNumberOfOneInBinary {

  /*
    The number of 1 in binary string in a number is
      + Even number: equals to count of 1 in number/2
      + Odd number: equals to count of 1 in (number/2) + 1
   */
  public static int[] calculate(int n) {
    int[] result = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      if (i % 2 == 0) {
        result[i] = result[i / 2];
      } else {
        result[i] = result[i / 2] + 1;
      }
    }
    return result;
  }
}
