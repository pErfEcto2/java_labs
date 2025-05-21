package lab4.task4_5;


import lab4.task1_2_3.Point;

public abstract class Shape implements Cloneable {
    protected Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        point = new Point(point.getX() + dx, point.getY() + dy);
    }

    public Point getCentre() {
        return point;
    }

    @Override
    public Shape clone() {
        try {
            Shape cloned = (Shape) super.clone();
            cloned.point = new Point(this.point.getX(), this.point.getY());
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("cant clone", e);
        }
    }
}
