package lab4.task4_5;


import lab4.task1_2_3.Point;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.height = height;
        this.width = width;
    }

    @Override
    public Point getCentre() {
        return new Point(point.getX() + width / 2, point.getY() - height / 2);
    }

    @Override
    public Rectangle clone() {
        return (Rectangle) super.clone();
    }
}