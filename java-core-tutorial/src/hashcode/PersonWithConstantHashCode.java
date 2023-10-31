package hashcode;

import java.util.Objects;

public class PersonWithConstantHashCode {

    private String name;
    private int age;

    public PersonWithConstantHashCode(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PersonWithConstantHashCode personWithHashCode = (PersonWithConstantHashCode) obj;
        return age == personWithHashCode.age && Objects.equals(name, personWithHashCode.name);
    }

    @Override
    public int hashCode() {
        return 5;
    }
}
