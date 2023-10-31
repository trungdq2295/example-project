package design_pattern.creational.prototype;


class Address {
    public String streetName;

    public int streetNumber;

    public Address(String streetName, int streetNumber) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public Address(Address other) {
        this.streetName = other.streetName;
        this.streetNumber = other.streetNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                '}';
    }
}

class Person {
    String name;

    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Person(Person other) {
        name = other.name;
        address = other.address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

public class CopyConstructor {

    public static void main(String[] args) {
        Person john = new Person("John" , new Address("Le Van Sy", 429));
        Person jane = new Person(john);
        jane.name = "Jane";
        System.out.println(john);
        System.out.println(jane);
    }
}

