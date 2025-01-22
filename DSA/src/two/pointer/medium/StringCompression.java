package two.pointer.medium;

public class StringCompression {

  /**
   * Given an array of characters chars, compress it using the following algorithm:
   * Begin with an empty string s. For each group of consecutive repeating characters in chars:
   * If the group's length is 1, append the character to s.
   * Otherwise, append the character followed by the group's length.
   * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
   * After you are done modifying the input array, return the new length of the array.
   * You must write an algorithm that uses only constant extra space.
   *
   *  Solution:
   *    The idea is to have 1 pointer to read and 1 pointer to write
   *    You will count the number of occurrences in each char
   *    just convert the count to string and char array and write to own Arrays ( this will cover the case count greater than 10)
   */

  public int compress(char[] chars) {
    int n = chars.length;
    if (n == 1) {
      return n;
    }

    int current = 0; // Write pointer
    int i = 0; // Read pointer

    while (i < n) {
      char ch = chars[i];
      int count = 0;
      while(i < n && chars[i] == ch){
        count++;
        i++;
      }
      chars[current++] = ch;
      if(count > 1){
        String countString = String.valueOf(count);
        for(char c: countString.toCharArray()){
          chars[current++] = c;
        }
      }

    }

    return current;
  }
}
