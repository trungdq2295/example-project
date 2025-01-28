package counting;

public class Topic_423 {

  /**
   * Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.
   * <p>
   * Solution:
   * The idea is you have some number which contains unique character
   * z(zero) -> 0
   * x(six)  -> 6
   * u(four) -> 4
   * w(two)  -> 2
   * g(eigth)-> 8
   * <p>
   * And some character belongs to some numbers
   * f(five+four) -> 5 && 4
   * o(one +two + four + zero) -> 1 && 2 && 4 && 0
   * t(three + eight + two) -> 3 && 8 && 2
   * s(seven + six) -> 7 && 6
   * i(nine + five + six + eight) -> 9 && 5 && 6 && 8
   * <p>
   * So What you gonna do is to count the character in the string, and you gonna do some math for number which unique character like digit[0] = map['z' - 'a'];
   * And for the character belongs to multipl number such as f, we gonna minus use the count and minus the number which already existed like digit[5] = map['f' - 'a'] - digit[4];
   */
  public String originalDigits(String s) {
    int[] map = new int[26];
    for (char c : s.toCharArray()) {
      map[c - 'a']++;
    }
    int[] digit = new int[10]; // from 0 to 9
    digit[0] = map['z' - 'a'];
    digit[2] = map['w' - 'a'];
    digit[4] = map['u' - 'a'];
    digit[6] = map['x' - 'a'];
    digit[8] = map['g' - 'a'];
    digit[5] = map['f' - 'a'] - digit[4];
    digit[1] = map['o' - 'a'] - digit[0] - digit[2] - digit[4];
    digit[3] = map['t' - 'a'] - digit[8] - digit[2];
    digit[7] = map['s' - 'a'] - digit[6];
    digit[9] = map['i' - 'a'] - digit[5] - digit[6] - digit[8];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      while (digit[i]-- > 0) {
        sb.append(i);
      }
    }
    return sb.toString();
  }
}
