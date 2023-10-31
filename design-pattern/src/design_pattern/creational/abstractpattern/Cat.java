package design_pattern.creational.abstractpattern;

public class Cat implements Animal{
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
