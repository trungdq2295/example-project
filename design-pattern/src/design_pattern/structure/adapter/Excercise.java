package design_pattern.structure.adapter;

public class Excercise {

    public static void main(String[] args) {
        Square square = new Square(8);
        SquareToRectangleAdapter abc = new SquareToRectangleAdapter(square);
        System.out.println(abc.rectangleObject.getArea());;
    }
}

interface Rectangle {
    int getWidth();

    int getHeight();

    default int getArea() {
        return getHeight() * getWidth();
    }
}

class Square {
    int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

class RectangleObject implements Rectangle {

    private int width;

    private int height;

    public RectangleObject(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}

class SquareToRectangleAdapter {
    public RectangleObject rectangleObject;

    public SquareToRectangleAdapter(Square square){
        this.rectangleObject = new RectangleObject(square.getSide(), square.getSide());
    }
}