package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("m2", "m3", "m1");
        System.out.println(Collections.binarySearch(list, "m3"));

        Collections.sort(list, null);
        System.out.println(Collections.binarySearch(list, "m3"));

        Collections.reverse(list);
        System.out.println(Collections.binarySearch(list, "m3"));
    }
}
