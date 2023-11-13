package design_pattern.creational.factory.abstractpattern;

import java.util.concurrent.atomic.AtomicInteger;

public class Assessment {
    private int id;

    private String name;


    public Assessment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class PersonFactory{

    public static AtomicInteger id = new AtomicInteger(0);

    public static Assessment createPerson(String name){
        return new Assessment(id.getAndIncrement(), name);
    }

    public static void main(String[] args) {
        Assessment person1 = PersonFactory.createPerson("Trung");
        Assessment person2 = PersonFactory.createPerson("Nguyen");
        System.out.println("person1: "+person1);
        System.out.println("person2: "+person2);
    }
}


