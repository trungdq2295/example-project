package design.medium;

import java.util.ArrayList;
import java.util.List;

public class Topic_731 {

  /**
   * My Calendar II
   * <p>
   * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.
   * A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).
   * The event can be represented as a pair of integers startTime and endTime that represents a booking on the half-open interval [startTime, endTime),
   * the range of real numbers x such that startTime <= x < endTime.
   * <p>
   * Implement the MyCalendarTwo class:
   * MyCalendarTwo() Initializes the calendar object.
   * boolean book(int startTime, int endTime) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
   * <p>
   * Solution:
   * The idea you gonna create two list, once is to store the current booking, and another is to store the 2 overbooking from the current booking
   * Everytime, we insert to the current booking, we gonna check if the start/end time is being overlapped the one in overlapBookings, if so, return false
   * If not, we gonna check if start/end time is overlapped to the current booking list, if so we need to adjust the start/end time and add to overlapbooking
   * <p>
   * Remember how to check overlap booking: event e and  start/end time
   * *  Math.max(e.start, start) < Math.min(e.end, end)
   */

  class Event {
    int start;
    int end;

    public Event(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  class MyCalendar {

    List<Event> bookings;

    List<Event> overlapBookings;

    public MyCalendar() {
      bookings = new ArrayList<>();
      overlapBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
      for (Event e : overlapBookings) {
        if (isOverlap(e, start, end)) {
          return false;
        }
      }
      for (Event e : bookings) {
        if (isOverlap(e, start, end)) {
          overlapBookings.add(getOverLap(e, start, end));
        }
      }
      bookings.add(new Event(start, end));

      return true;
    }


    private boolean isOverlap(Event e, int start, int end) {
      return Math.max(e.start, start) < Math.min(e.end, end);
    }

    private Event getOverLap(Event e, int start, int end) {
      return new Event(Math.max(e.start, start), Math.min(e.end, end));
    }
  }
}
