package design_pattern.creational.factory.abstractpattern;

public class Cat implements Animal{
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
