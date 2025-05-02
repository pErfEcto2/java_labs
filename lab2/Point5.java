package lab2;


import java.util.List;

/**
 * Immutable Point class
 */
public class Point5 implements Shape {
    private final double x;
    private final double y;

    public Point5(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }

    public double getY() { return y; }

    @Override
    public java.util.List<Shape> intersect(Shape other) {
        return java.util.List.of(); // Not implemented
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point5)) return false;
        return x == ((Point5) o).x && y == ((Point5) o).y;
    }
}
