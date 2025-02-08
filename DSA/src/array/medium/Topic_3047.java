package array.medium;

public class Topic_3047 {

  /**
   * There exist n rectangles in a 2D plane with edges parallel to the x and y axis.
   * You are given two 2D integer arrays bottomLeft and topRight
   * where bottomLeft[i] = [a_i, b_i] and topRight[i] = [c_i, d_i] represent the bottom-left and top-right coordinates of the ith rectangle, respectively.
   * You need to find the maximum area of a square that can fit inside the intersecting region of at least two rectangles. Return 0 if such a square does not exist.
   * <p>
   * Solution:
   * The idea is you gonna check the intersection between 2 rectangle
   * Condition will be:
   * There's will be no intersection if:
   * - on the x-axis:
   * + the bottom left of second rectangle greater than first rectangle top right
   * + the top right of second rectangle lesser than first rectangle bottom left
   * - on the y-axis
   * + second rectangle top right is lesser than first rectangle bottom left
   * + second rectangle bottom left greater than first rectangle top right
   * After skipping no intersection, we gonna loop to find the intersection area between 2 area
   * by finding the minimum of the width and height of the intersection
   * And the reason we find the minimum because if we use the greater value, it not gonna fit into the intersection
   * Finally, we updated the maximum area
   */
  public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
    int answer = 0,
      n = bottomLeft.length;

    for (int i = 0; i < n; i++) {
      int[] firstRectangleBL = bottomLeft[i];
      int[] firstRectangleTR = topRight[i];

      for (int j = i + 1; j < n; j++) {
        int[] secondRectangleBL = bottomLeft[j];
        int[] secondRectangleTR = topRight[j];

        /**
         There's will be no intersection if:
         - on the x-axis:
         + the bottom left of second rectangle greater than first rectangle top right
         + the top right of second recetangle lesser than first rectangle bottom left

         */
        if (secondRectangleBL[0] >= firstRectangleTR[0] || secondRectangleTR[0] <= firstRectangleBL[0]) {
          continue;
        }
        /**
         - on the y-axis
         + second rectangle top right is lesser than first rectangle bottom left
         + second rectangle bottom left greater than first rectangle top right
         */
        if (secondRectangleTR[1] <= firstRectangleBL[1] || secondRectangleBL[1] >= firstRectangleTR[1]) {
          continue;
        }

        int pointAX = Math.max(firstRectangleBL[0], secondRectangleBL[0]);
        int pointAY = Math.max(firstRectangleBL[1], secondRectangleBL[1]);

        int pointBX = Math.min(firstRectangleTR[0], secondRectangleTR[0]);
        int pointBY = Math.min(firstRectangleTR[1], secondRectangleTR[1]);

        int sizeA = pointBX - pointAX;
        int sizeB = pointBY - pointAY;
        answer = Math.max(answer, Math.min(sizeA, sizeB));
      }
    }
    return (long) answer * answer;
  }
}
