package design_pattern.behavior.state;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A combination lock is a lock that opens after the right digits have been entered. A lock is preprogrammed with a combination (e.g., 12345 ) and the user is expected to enter this combination to unlock the lock.
 * <p>
 * The lock has a status  field that indicates the state of the lock. The rules are:
 * <p>
 * If the lock has just been locked (or at startup), the status is LOCKED.
 * If a digit has been entered, that digit is shown on the screen. As the user enters more digits, they are added to status .
 * If the user has entered the correct sequence of digits, the lock status changes to OPEN.
 * If the user enters an incorrect sequence of digits, the lock status changes to ERROR.
 * Please implement the CombinationLock  class to enable this behavior. Be sure to test both correct and incorrect inputs.
 * <p>
 * Here is an example unit test for the lock:
 * <p>
 * CombinationLock cl = new CombinationLock(new int[]{1, 2, 3, 4});
 * assertEquals("LOCKED", cl.status);
 * cl.enterDigit(1);
 * assertEquals("1", cl.status);
 * cl.enterDigit(2);
 * assertEquals("12", cl.status);
 * cl.enterDigit(3);
 * assertEquals("123", cl.status);
 * cl.enterDigit(4);
 * assertEquals("OPEN", cl.status);
 */
public class Excercise {

    public static void main(String[] args) {
        CombinationLock cl = new CombinationLock(new int[]{1, 2, 3, 4});
        cl.enterDigit(1);
        System.out.println(cl.status);
    }
}

class CombinationLock {
    private int[] combination;
    private String result;
    public String status;

    private List<Integer> list = new ArrayList<>();

    public CombinationLock(int[] combination) {
        this.combination = combination;
        this.status = "LOCKED";
        result = Arrays.stream(this.combination)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
    }

    public void enterDigit(int digit) {
        if (!IntStream.of(combination).anyMatch(x -> x == digit)) {
            this.status = "ERROR";
            return;
        }
        list.add(digit);
        String current = list.stream().map(String::valueOf).collect(Collectors.joining(""));
        updateStatus(current);
        // todo: check digit and update status here
    }

    public void updateStatus(String current) {
        this.status = current.equals(result) ? "OPEN" : current;
    }
}
