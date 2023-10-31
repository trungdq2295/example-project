package design_pattern.creational.prototype;


import java.io.Serializable;

class Foo implements Serializable{
    int stuff;
    String name;

    public Foo(int stuff, String name) {
        this.stuff = stuff;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "stuff=" + stuff +
                ", name='" + name + '\'' +
                '}';
    }
}

public class SerializationCopy {

    public static void main(String[] args) {
        Foo foo = new Foo(42 ,"life");
    }
}
