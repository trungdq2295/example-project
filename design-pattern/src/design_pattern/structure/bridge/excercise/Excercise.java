package design_pattern.structure.bridge.excercise;

public class Excercise {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(new VectorRenderer());
        System.out.println(triangle);
        triangle = new Triangle(new RasterRenderer());
        System.out.println(triangle);
    }
}


interface Renderer {
    String whatToRenderAs();
}

class VectorRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

class RasterRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public String toString() {
        return "Drawing Triangle as " + renderer.whatToRenderAs();
    }
}

class Triangle extends Shape {

    public Triangle(Renderer renderer) {
        super(renderer);
    }

}