package example.nine.version.interfaceexample;

public class People implements Human {

    @Override
    public void run() {
        System.out.println("Running");
    }

    public static void main(String[] args) {
        People people = new People();
        people.awake();
        people.run();
        people.sleep();
        Human.doJob1();
    }
}
