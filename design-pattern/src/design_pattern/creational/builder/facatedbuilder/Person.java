package design_pattern.creational.builder.facatedbuilder;

public class Person {

    String address;
    String city;

    String postCode;

    String firstName;

    String lastName;

    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder
                .names()
                    .withFirstName("Trung")
                    .withLastName("Doan")
                .lives()
                    .withCity("Ho Chi Minh")
                    .withAddress("4567")
                .build();
        System.out.println(person);
    }

    @Override
    public String toString() {
        return "Person{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

class PersonBuilder {

    protected Person person = new Person();

    public PersonNameBuilder names(){
        return new PersonNameBuilder(person);
    }

    public PersonAddressBuilder lives(){
        return new PersonAddressBuilder(person);
    }

    public Person build() {
        return person;
    }
}

class PersonNameBuilder extends PersonBuilder {
    public PersonNameBuilder(Person person) {
        this.person = person;
    }

    public PersonNameBuilder withFirstName(String firstName) {
        this.person.firstName = firstName;
        return this;
    }

    public PersonNameBuilder withLastName(String lastName) {
        this.person.lastName = lastName;
        return this;
    }
}


class PersonAddressBuilder extends PersonBuilder {
    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder withAddress(String address) {
        this.person.address = address;
        return this;
    }

    public PersonAddressBuilder withCity(String city) {
        this.person.city = city;
        return this;
    }
}
