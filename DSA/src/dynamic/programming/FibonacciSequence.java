package dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSequence {

  static Map<Integer, Long> map = new HashMap<>();

  public static long fib(int n) {
    if (map.containsKey(n)) {
      return map.get(n);
    }
    if (n == 0 || n == 1) {
      return n;
    }
    long result = fib(n - 1) + fib(n - 2);
    map.put(n, result);
    return result;
  }

  public static void main(String[] args) {
    long current = System.currentTimeMillis();
    System.out.println(fib(1000));
    System.out.println(System.currentTimeMillis() - current);
  }
}
