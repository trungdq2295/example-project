package classxample.inheritance;

public class Inheritance {
}

interface ParentInterface {
    static void staticMethod() {
        System.out.println("Static method in Parent interface");
    }
}

interface ChildInterface extends ParentInterface {
    // Does not inherit Parent's static method
}


class Parent {
    static void staticMethod() {
        System.out.println("Static method in Parent class");
    }
}

class Child extends Parent {
    static void staticMethod() {
        System.out.println("Static method in Child class");
    }
}

class Main {
    public static void main(String[] args) {
        Parent.staticMethod(); // Outputs: Static method in Parent class
        Child.staticMethod();  // Outputs: Static method in Child class

        Parent obj = new Child();
        Child child = (Child) obj;
        obj.staticMethod();    // Outputs: Static method in Parent class (no polymorphism)
        child.staticMethod();    // Outputs: Static method in Child class (no polymorphism)
        ParentInterface.staticMethod();
    }
}