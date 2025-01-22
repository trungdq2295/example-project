package two.pointer.hard;

public class TrappingRainWater {

  /**
   * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
   * Solution:
   * The idea is to create 2 pointer left at index 0 and right at index n-1, and leftMax, rightMax
   * During iterate, we check if the max(left or right) is greater than the other (right or left)
   * Then we move our pointer (left++ or right--)
   * Everytime, we check our max(leftMax/rightMax), we calculate the water can be stored in the current position
   * Until, our pointers meet and we exit the loop
   */
  public int trap(int[] height) {
    int n = height.length;
    int water = 0;
    int left = 0, right = n - 1;
    int leftMax = height[left], rightMax = height[right];
    while (left < right) {
      if (leftMax < rightMax) {
        left++;
        leftMax = Math.max(leftMax, height[left]);
        water += leftMax - height[left];
      } else {
        right--;
        rightMax = Math.max(rightMax, height[right]);
        water += rightMax - height[right];
      }
    }
    return water;
  }
}
