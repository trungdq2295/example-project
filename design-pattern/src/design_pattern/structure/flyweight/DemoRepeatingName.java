package design_pattern.structure.flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class DemoRepeatingName {

    public static void main(String[] args) {
        User user = new User("John Smith");
        User user2 = new User("Jane Smith");

        UserV2 userv2 = new UserV2("John Smith");
        UserV2 userV22 = new UserV2("Jane Smith");
    }
}

class User {
    private String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }
}

class UserV2 {
    static List<String> strings = new ArrayList<>();

    private int[] names;


    public UserV2(String fullName) {
        Function<String, Integer> getOrAdd = (String s) -> {
            int idx = strings.indexOf(s);
            if (idx != -1) {
                return idx;
            } else {
                strings.add(s);
                return strings.size() - 1;
            }
        };

        names = Arrays.stream(fullName.split(" "))
                .mapToInt(s -> getOrAdd.apply(s))
                .toArray();
    }
}