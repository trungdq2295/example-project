package interface_seggeration_principle;

public class Animal {

    private String name;

    private int numberOfLegs;

    public Animal(String name, int numberOfLegs) {
        this.name = name;
        this.numberOfLegs = numberOfLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
}
