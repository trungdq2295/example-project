package hashcode;

import java.util.Objects;

public class PersonWithHashCode {

    private String name;
    private int age;

    public PersonWithHashCode(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PersonWithHashCode personWithHashCode = (PersonWithHashCode) obj;
        return age == personWithHashCode.age && Objects.equals(name, personWithHashCode.name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        return result;
    }
}
