package greedy.medium;

public class Topic_3440 {
  /**
   * You are given an integer eventTime denoting the duration of an event. You are also given two integer arrays startTime and endTime, each of length n.
   * These represent the start and end times of n non-overlapping meetings that occur during the event between time t = 0 and time t = eventTime, where the ith meeting occurs during the time [startTime[i], endTime[i]].
   * You can reschedule at most one meeting by moving its start time while maintaining the same duration, such that the meetings remain non-overlapping, to maximize the longest continuous period of free time during the event.
   * Return the maximum amount of free time possible after rearranging the meetings.
   * Note that the meetings can not be rescheduled to a time outside the event and they should remain non-overlapping.
   * Note: In this version, it is valid for the relative ordering of the meetings to change after rescheduling one meeting.
   * <p>
   * Solution:
   * We gonna track the freeTime at each "i" event by the formula: startTime[i] - endTime[i-1]
   *    => freeTime[0] = startTime[0] - 0; //since we gonna have free time from 0 to startTime[0]
   *    => at Last event, freeTime[n] = eventTime - endTime[n-1]; // Since we have total 10 hour and the last event end at 9 => 10 - 9 = 1 free time
   *  We gonna create 2 arrays to store the maximum freeTime we can achieve from left, and maximum freeTime we can achieve from right
   *  After that, we gonna iterate each event
   *    At each event, We calculate the free time between 2 event i and i + 1
   *    and the target is the busy event time
   *    We gonna check if we remove this busy time, will it give us the largest or not
   *    And then we gonna check ,if any previous (maxILeft) or the next(maxIright) is greater or equal to the target so we can merge the time
   *
   */
  public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
    int n = startTime.length;
    int[] freeTime = new int[n + 1];
    freeTime[0] = startTime[0];
    for (int i = 1; i < n; i++) {
      freeTime[i] = startTime[i] - endTime[i - 1];
    }
    freeTime[n] = eventTime - endTime[n - 1];
    int[] maxiLeft = new int[n + 1];
    int[] maxiRight = new int[n + 1];
    int max = -1;
    for (int i = 0; i <= n; i++) { // calculate the max freeTime from left
      max = Math.max(max, freeTime[i]);
      maxiLeft[i] = max;
    }
    max = -1;
    for (int i = n; i >= 0; i--) { // calculate the max freeTime from right
      max = Math.max(max, freeTime[i]);
      maxiRight[i] = max;
    }
    int answer = 0;
    for (int i = 0; i < n; i++) {
      int target = (endTime[i] - startTime[i]);
      /**
       We calculate the free time between 2 event i and i + 1
       and the target here is the busy event time
       We gonna check if we remove this busy time, it can give us the larget possible
       */
      int current = freeTime[i] + target + freeTime[i + 1];
      answer = Math.max(answer, current - target);
      /**
       If any previous (maxiLeft) or the next (maxiRight) is largest as the target, we can merge the current busy event to these
       */
      if ((i > 0 && maxiLeft[i - 1] >= target) || (i + 2 <= n && maxiRight[i + 2] >= target)) {
        answer = Math.max(answer, current);
      }
    }
    return answer;
  }
}
