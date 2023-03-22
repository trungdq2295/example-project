package example.concurrencyexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tessst {

    public static void main(String[] args) {
        List<String> abc = new ArrayList<>();
        abc.add("abc");
        abc.add("xuy");
        System.out.println(Arrays.toString(abc.toArray()));
        List<String> xyz = new ArrayList<>(abc);
        xyz.add("456");
        System.out.println(Arrays.toString(xyz.toArray()));
    }
}
