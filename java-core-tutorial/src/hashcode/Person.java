package hashcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        // Uncomment the line below to use a fixed hash code
         return 1;

        // Uncomment the line below to use a random hash code
//         return new Random().nextInt();
    }

    public static void main(String[] args) {
        Map<Person, Integer> map = new HashMap<>();
        Person person1 = new Person("John");
        Person person2 = new Person("John");

        map.put(person1, 25);
        System.out.println("Age of John: " + map.get(person2));
    }
}