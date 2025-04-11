package lab2;


/**
 * Mutable Point class
 */
public class Point6 {
    private double x;
    private double y;

    public Point6() {
        x = 0;
        y = 0;
    }

    public Point6(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void scale(double value) {
        this.x *= value;
        this.y *= value;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

}
