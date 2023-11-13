package design_pattern.creational.factory.abstractpattern;

public class Dog implements Animal{
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
