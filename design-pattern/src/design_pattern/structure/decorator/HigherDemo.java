package design_pattern.structure.decorator;

import java.util.function.Supplier;

public class HigherDemo {

    public static void main(String[] args) {
        ColoredShaped<Square> blueSquare = new ColoredShaped<>(
                () -> new Square(20), "blue"
        );
        System.out.println(blueSquare.info());
        Circle circle = new Circle(5);

        TransparentShape<ColoredShaped<Circle>> myCircle = new TransparentShape<>(
                () -> new ColoredShaped<>(() -> circle,"red"),5
        );
        System.out.println(myCircle.info());
        circle.resize(4);
        System.out.println(myCircle.info());
    }
}

interface Shape {
    String info();
}

class Circle implements Shape {

    private float radius;

    public Circle() {

    }

    public Circle(float radius) {
        this.radius = radius;
    }

    public void resize(float factor) {
        this.radius *= factor;
    }

    @Override
    public String toString() {
        return "A circle of radius " + radius;
    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}

class Square implements Shape {

    private float side;

    public Square() {

    }

    public Square(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A square of side " + this.side;
    }
}


class ColoredShaped<T extends Shape> implements Shape {

    private Shape shape;

    private String color;

    public ColoredShaped(Supplier<? extends T> supplier, String color) {
        this.color = color;
        this.shape = supplier.get();
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparentShape<T extends Shape> implements Shape {

    private Shape shape;

    private int transparent;

    public TransparentShape(Supplier<? extends T> supplier, int transparent) {
        this.shape = supplier.get();
        this.transparent = transparent;
    }

    @Override
    public String info() {
        return shape.info() + " has " + this.transparent + " % transparent";
    }
}
