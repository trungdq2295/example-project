package design_pattern.structure.proxy;

public class Excercise {
}


class Person231 {
    private int age;

    public Person231(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String drink() {
        return "drinking";
    }

    public String drive() {
        return "driving";
    }

    public String drinkAndDrive() {
        return "driving while drunk";
    }
}

class ResponsiblePerson {
    private Person231 person;

    public ResponsiblePerson(Person231 person) {
        this.person = person;
    }

    public void setAge(int age){
        this.person.setAge(age);
    }

    public String drink() {
        return this.person.getAge() >= 18 ? this.person.drink() : "too young";
    }

    public String drive() {
        return this.person.getAge() >= 16 ? this.person.drive() : "too young";
    }

    public  String drinkAndDrive() { return "dead"; }
}