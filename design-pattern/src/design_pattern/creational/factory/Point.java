package design_pattern.creational.factory;

public class Point {

    private double x;

    private double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double x, double y) {
        return new Point(Math.cos(x), Math.sin(y));
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point cartesianPoint = Point.newCartesianPoint(2, 3);
        System.out.println(cartesianPoint);
        Point polarPoint = Point.newPolarPoint(2, 3);
        System.out.println(polarPoint);
    }
}
