package hashcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExampleTest {

    public static void exampleSet() {
        long currentTime = System.currentTimeMillis();
        /*
         * With Random Hashcode, the insertion will be faster than constant hashcode in object
         */
        Set<PersonWithHashCode> set = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            set.add(new PersonWithHashCode("Person" + i, i));
        }
        System.out.println("With Random HashCode: " + (System.currentTimeMillis() - currentTime));
        currentTime = System.currentTimeMillis();
        Set<PersonWithConstantHashCode> set123 = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            set123.add(new PersonWithConstantHashCode("Person" + i, i));
        }
        System.out.println("With Constant HashCode: " + (System.currentTimeMillis() - currentTime));
    }

    public static void exampleHashMap() {
        long currentTime = System.currentTimeMillis();
        /*
         * With Random Hashcode, the insertion will be faster than constant hashcode in object
         */
        System.out.println("Insert Data");
        Map<PersonWithHashCode, Integer> set = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            set.put(new PersonWithHashCode("Person" + i, i), i);
        }
        System.out.println("With Random HashCode: " + (System.currentTimeMillis() - currentTime));
        currentTime = System.currentTimeMillis();
        Map<PersonWithConstantHashCode, Integer> set123 = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            set123.put(new PersonWithConstantHashCode("Person" + i, i),i);
        }
        System.out.println("With Constant HashCode: " + (System.currentTimeMillis() - currentTime));

        System.out.println("Get data");
        currentTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.print(set.get(new PersonWithHashCode("Person" + i, i)));
        }
        System.out.println("With Random HashCode: " + (System.currentTimeMillis() - currentTime));

        currentTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.print(set123.get(new PersonWithConstantHashCode("Person" + i, i)));
        }
        System.out.println("With Constant HashCode: " + (System.currentTimeMillis() - currentTime));
    }

    public static void main(String[] args) {
//        exampleSet();
        exampleHashMap();
    }
}
