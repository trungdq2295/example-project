package solid.interface_seggeration_principle;

public class Dog extends Animal implements Run,Walk{
    public Dog(String name) {
        super(name, 4);
    }

    @Override
    public void run() {

    }

    @Override
    public void walk() {

    }
}
