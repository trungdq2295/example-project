package design_pattern.creational.builder;

public class Person {

    String name;

    int age;

}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public Person build() {
        return person;
    }

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{

    public EmployeeBuilder withAge(int age){
        person.age = age;
        return self();
    }

    protected EmployeeBuilder self(){
        return this;
    }
}




