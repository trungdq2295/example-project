package queue.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Topic_950 {

  /**
   * You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is deck[i].
   * You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
   * You will do the following steps repeatedly until all cards are revealed:
   * Take the top card of the deck, reveal it, and take it out of the deck.
   * If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
   * If there are still unrevealed cards, go back to step 1. Otherwise, stop.
   * Return an ordering of the deck that would reveal the cards in increasing order.
   * <p>
   * Note that the first entry in the answer is considered to be the top of the deck.
   * <p>
   * Solution: Think about using Dequeue (double-ended queue)
   * First of all, we gonna sort the array to get the lowest element
   * After that, we use a Deque to store the indices we processed
   * At each index  we poll the indices from the front, we gonna put the value of card into that index
   * after that, we check if dequeue is not empty, then we poll the next indice and add it to the back of the queue
   */
  public int[] deckRevealedIncreasing(int[] deck) {
    Arrays.sort(deck);
    int n = deck.length;
    int[] res = new int[n];
    Queue<Integer> indices = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      indices.add(i);
    }

    for (int card : deck) {
      int idx = indices.poll();
      res[idx] = card;
      if (!indices.isEmpty()) {
        indices.add(indices.poll());
      }
    }
    return res;
  }
}
