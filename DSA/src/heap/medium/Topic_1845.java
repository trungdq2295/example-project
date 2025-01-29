package heap.medium;

import java.util.PriorityQueue;

public class Topic_1845 {

  class SeatManager {
    /**
     * Design a system that manages the reservation state of n seats that are numbered from 1 to n.
     * Implement the SeatManager class:
     * SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
     * int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
     * void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
     * <p>
     * Solution:
     * The idea is you will have a pointer to point to the last seat which can be booked
     * For example: You have 5 seats, and then there's 3 reserved, then your pointer will point to 4
     * However when the seat 2 unreserved but seat 3 doesn't, Your pointer still point to 4
     * You will need a heap to store that 2 value, so the next reserve will be 2 not 4, until your heap is empty, then we gonna use your pointer
     */

    private int last;
    /**
     * We use heap to store the seat which wasn't the last to remove
     * So in this case, we will be able to get smallest number
     */
    PriorityQueue<Integer> pq;

    public SeatManager(int n) {
      last = 0;
      pq = new PriorityQueue<>();
    }

    public int reserve() {
      if (pq.isEmpty()) {
        return ++last;
      } else {
        return pq.poll();
      }
    }

    public void unreserve(int seatNumber) {
      if (last == seatNumber) {
        --last;
      } else {
        pq.offer(seatNumber);
      }
    }
  }

}
