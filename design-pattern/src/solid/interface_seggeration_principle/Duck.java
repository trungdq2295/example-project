package solid.interface_seggeration_principle;

public class Duck extends Animal implements Run,Walk,Fly{


    public Duck(String name, int numberOfLegs) {
        super(name, numberOfLegs);
    }

    @Override
    public void fly() {

    }

    @Override
    public void run() {

    }

    @Override
    public void walk() {

    }
}
