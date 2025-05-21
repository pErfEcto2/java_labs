package lab4.task4_5;


import lab4.task1_2_3.Point;

public class Line extends Shape {
    private final Point to;

    public Line(Point from, Point to) {
        super(from);
        this.to = to;
    }

    @Override
    public Point getCentre() {
        return new Point((point.getX() + to.getX()) / 2, (point.getY() + to.getY()) / 2);
    }

    @Override
    public Line clone() {
        return (Line) super.clone();
    }
}
