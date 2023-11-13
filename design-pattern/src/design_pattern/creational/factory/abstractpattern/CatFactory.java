package design_pattern.creational.factory.abstractpattern;

public class CatFactory implements AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
