//package design_pattern.behavior.state;
//
//public class ClassicImplementationDemo {
//    public static void main(String[] args) {
//        LightSwitch lightSwitch = new LightSwitch();
//        lightSwitch.on();
//        lightSwitch.off();
//        lightSwitch.off();
//    }
//}
//
//
//class State {
//    void on(LightSwitch ls) {
//        System.out.println("Light is already on");
//    }
//
//    void off(LightSwitch ls) {
//        System.out.println("Light is already off");
//        ls.setState(new OffState());
//    }
//}
//
//class OnState extends State {
//
//    public OnState() {
//        System.out.println("Light turn on");
//    }
//
//    @Override
//    void off(LightSwitch ls) {
//        System.out.println("Switching Light off...");
//    }
//}
//
//class OffState extends State {
//
//    public OffState(){
//        System.out.println("Light turned off");
//    }
//
//    @Override
//    void on(LightSwitch ls) {
//        System.out.println("Switching light on..");
//        ls.setState(new OnState());
//    }
//}
//
//class LightSwitch {
//    private State state;
//
//    public LightSwitch() {
//        state = new OffState();
//    }
//
//    void on() {
//        state.on(this);
//    }
//
//    void off() {
//        state.off(this);
//    }
//
//    public void setState(State state) {
//        this.state = state;
//    }
//}
//
