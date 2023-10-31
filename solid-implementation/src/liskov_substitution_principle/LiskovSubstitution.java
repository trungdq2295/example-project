package liskov_substitution_principle;

public class LiskovSubstitution {

    public static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Area: " + width * 10 + " , " + r.getArea());
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 5);
        useIt(r);

        /*
            this one is break it
            the result should be 25
         */
        Square s = new Square(5);
        useIt(s);
        /**
         * The idea of liskv substitution is that you don't break it when you substitute a sub class
         */
        // To handle this you can use factory method design pattern to handle it
    }
}
