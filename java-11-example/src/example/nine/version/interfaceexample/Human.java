package example.nine.version.interfaceexample;

public interface Human {
    default void awake() {
        doSomething();
    }

    default void sleep() {
        doSomethingStatic();
    }

    void run();

    private void doSomething() {
        System.out.println("Same code here");
    }

    private static void doSomethingStatic() {
        System.out.println("static ");
    }

    static void doJob1() {
        doSomethingStatic();
        System.out.println("Do job 1");
    }
}
