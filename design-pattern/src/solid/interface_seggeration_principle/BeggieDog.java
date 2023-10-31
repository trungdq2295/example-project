package solid.interface_seggeration_principle;

public class BeggieDog extends Dog{
    public BeggieDog(String name) {
        super(name);
    }

    @Override
    public void walk(){
        System.out.println("Fast");
    }
}
