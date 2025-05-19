package lab4.task4FromList;


public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }
}
