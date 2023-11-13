package design_pattern.creational.factory.abstractpattern;

public class DogFactory implements AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
