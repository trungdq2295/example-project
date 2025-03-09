package two.pointer.medium;

public class Topic_1616 {


  /**
   * Split Two Strings to Make Palindrome
   * <p>
   * You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.
   * When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.
   * Return true if it is possible to form a palindrome string, otherwise return false.
   * Notice that x + y denotes the concatenation of strings x and y.
   * <p>
   * <p>
   * Solution:
   * The idea is you need to check from left of "a" and from right of "b", it can form a palindrome string
   * So we gonna start to iterate from left of a and from right of b, we gonna check if the char at that left, right is equals
   */
  public boolean checkPalindromeFormation(String a, String b) {
    return isPalindrome(a, b) || isPalindrome(b, a);
  }

  private boolean isPalindrome(String a, String b) {
    int left = 0,
      right = a.length() - 1;
    while (left < right) {
      if (a.charAt(left) != b.charAt(right)) {
        break;
      }
      left++;
      right--;
    }
    return isPalindrome(a, left, right) || isPalindrome(b, left, right);
  }

  private boolean isPalindrome(String word, int left, int right) {
    while (left < right) {
      if (word.charAt(left) != word.charAt(right)) {
        break;
      }
      left++;
      right--;
    }
    return left >= right;
  }
}
