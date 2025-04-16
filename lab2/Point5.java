package lab2;


/**
 * Immutable Point class
 */

public final class Point5 {
    private final double x;
    private final double y;

    public Point5() {
        x = 0;
        y = 0;
    }

    public Point5(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point5 translate(double x, double y) {
        return new Point5(x + x, y + y);
    }

    public Point5 scale(double value) {
        return new Point5(x * value, y * value);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
