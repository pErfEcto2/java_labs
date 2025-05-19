package lab2;


import java.util.ArrayList;
import java.util.List;


/**
 * Base interface for geometric shapes that support intersection
 */
interface Shape {
    /**
     * Returns string with info about a shape
     * @return string with info about a shape
     */
    String print();
}

/**
 * Represents a line segment between two points
 */
class Line implements Shape {
    /** Start point of the line */
    private final Point5 start;
    /** End point of the line */
    private final Point5 end;

    /**
     * Constructs a line between two given points
     * @param start start point
     * @param end end point
     */
    public Line(Point5 start, Point5 end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the start point of the line
     * @return start point
     */
    public Point5 getStart() { return start; }

    /**
     * Returns the end point of the line
     * @return end point
     */
    public Point5 getEnd() { return end; }

    public List<Shape> intersect(Shape other) {
        return List.of(); // Not implemented
    }

    @Override
    public String print() {
        return "Line[" + start + "; " + end + "]";
    }

    @Override
    public String toString() {
        return this.print();
    }
}

/**
 * Represents an axis-aligned rectangle defined by two diagonal corner points
 */
public class Rectangle implements Shape {
    /** Bottom-left corner of the rectangle */
    private final Point5 bottomLeft;
    /** Top-right corner of the rectangle */
    private final Point5 topRight;

    /**
     * Constructs a rectangle from two diagonal points
     * @param p1 first corner
     * @param p2 opposite corner
     */
    public Rectangle(Point5 p1, Point5 p2) {
        double x1 = Math.min(p1.getX(), p2.getX());
        double y1 = Math.min(p1.getY(), p2.getY());
        double x2 = Math.max(p1.getX(), p2.getX());
        double y2 = Math.max(p1.getY(), p2.getY());
        this.bottomLeft = new Point5(x1, y1);
        this.topRight = new Point5(x2, y2);
    }

    /**
     * Copy constructor
     * @param other rectangle;  copy
     */
    public Rectangle(Rectangle other) {
        this.bottomLeft = other.bottomLeft;
        this.topRight = other.topRight;
    }

    /**
     * Returns the bottom-left corner point
     * @return bottom-left point
     */
    public Point5 getBottomLeft() { return bottomLeft; }

    /**
     * Returns the top-right corner point
     * @return top-right point
     */
    public Point5 getTopRight() { return topRight; }

    public List<Shape> intersect(Shape other) {
        if (other instanceof Rectangle r) {
            return intersectWithRectangle(r);
        }
        return List.of();
    }

    /**
     * Computes the intersection with another rectangle
     * @param other the other rectangle
     * @return list of intersected shapes (points, lines or rectangle)
     */
    private List<Shape> intersectWithRectangle(Rectangle other) {
        List<Shape> result = new ArrayList<>();

        if (this.bottomLeft.equals(other.bottomLeft) && this.topRight.equals(other.topRight)) {
            result.add(this);
            return result;
        }

        List<Line> thisEdges = getEdges();
        List<Line> otherEdges = other.getEdges();

        ArrayList<Point5> points = new ArrayList<>();

        for (Line e1 : thisEdges) {
            inner_loop:
            for (Line e2 : otherEdges) {
                Line overlap = edgeOverlap(e1, e2);
                if (overlap != null) {
                    result.add(overlap);
                } else {
                    Point5 p = findLineIntersection(e1, e2);
                    if (p != null) {
                        for (Point5 pp : points) {
                            if (pp.getX() == p.getX() && pp.getY() == p.getY()) continue inner_loop;
                        }
                        points.add(p);
                    }
                }
            }
        }

        if (!result.isEmpty()) {
            return result;
        } else {
            return new ArrayList<>(points);
        }
    }

    /**
     * Returns rectangle edges as a list of lines in clockwise order
     * @return list of edges
     */
    private List<Line> getEdges() {
        Point5 br = new Point5(topRight.getX(), bottomLeft.getY());
        Point5 tl = new Point5(bottomLeft.getX(), topRight.getY());

        return List.of(
                new Line(bottomLeft, br), // bottom
                new Line(br, topRight),   // right
                new Line(topRight, tl),   // top
                new Line(tl, bottomLeft)  // left
        );
    }

    /**
     * Returns the overlapping portion of two axis-aligned edges, if any
     * @param l1 first edge
     * @param l2 second edge
     * @return overlapping line segment or null
     */
    private Line edgeOverlap(Line l1, Line l2) {
        Point5 a1 = l1.getStart(), a2 = l1.getEnd();
        Point5 b1 = l2.getStart(), b2 = l2.getEnd();

        if (a1.getY() == a2.getY() && b1.getY() == b2.getY() && a1.getY() == b1.getY()) {
            // horizontal lines
            double x1 = Math.max(Math.min(a1.getX(), a2.getX()), Math.min(b1.getX(), b2.getX()));
            double x2 = Math.min(Math.max(a1.getX(), a2.getX()), Math.max(b1.getX(), b2.getX()));
            if (x1 < x2) return new Line(new Point5(x1, a1.getY()), new Point5(x2, a1.getY()));
        }

        if (a1.getX() == a2.getX() && b1.getX() == b2.getX() && a1.getX() == b1.getX()) {
            // vertical lines
            double y1 = Math.max(Math.min(a1.getY(), a2.getY()), Math.min(b1.getY(), b2.getY()));
            double y2 = Math.min(Math.max(a1.getY(), a2.getY()), Math.max(b1.getY(), b2.getY()));
            if (y1 < y2) return new Line(new Point5(a1.getX(), y1), new Point5(a1.getX(), y2));
        }

        return null;
    }

    @Override
    public String toString() {
        return this.print();
    }

    /**
     * Finds the intersection point between two line segments if they intersect
     * @param l1 first line
     * @param l2 second line
     * @return intersection point or null
     */
    private Point5 findLineIntersection(Line l1, Line l2) {
        Point5 p1 = l1.getStart(), p2 = l1.getEnd();
        Point5 p3 = l2.getStart(), p4 = l2.getEnd();

        double x1 = p1.getX(), y1 = p1.getY();
        double x2 = p2.getX(), y2 = p2.getY();
        double x3 = p3.getX(), y3 = p3.getY();
        double x4 = p4.getX(), y4 = p4.getY();

        double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
        if (denom == 0) return null;

        double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / denom;
        double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / denom;

        if (ua >= 0 && ua <= 1 && ub >= 0 && ub <= 1) {
            double x = x1 + ua * (x2 - x1);
            double y = y1 + ua * (y2 - y1);
            return new Point5(x, y);
        }

        return null;
    }

    @Override
    public String print() {
        return "Rectangle[" + bottomLeft + "; " + topRight + "]";
    }

    /**
     * Tests
     */
    public static void main(String[] args) {
        ArrayList<Rectangle> rects = new ArrayList<>();
        rects.add(new Rectangle(new Point5(0, 0), new Point5(4, 4)));
        rects.add(new Rectangle(new Point5(2, 2), new Point5(6, 6)));
        rects.add(new Rectangle(new Point5(10, 10), new Point5(15, 15)));
        rects.add(new Rectangle(new Point5(-1, -1), new Point5(0, 0)));
        rects.add(new Rectangle(new Point5(-1, 1), new Point5(7, 3)));
        rects.add(new Rectangle(new Point5(0, 0), new Point5(4, 2)));
        rects.add(new Rectangle(rects.getFirst()));

        for (int i = 1; i < 7; i++) {
            System.out.println("Checking 1 and " + (i + 1) + " rects");
            List<Shape> intersections = rects.getFirst().intersect(rects.get(i));

            if (intersections.isEmpty()) {
                System.out.println("1 and " + (i + 1) + " rectangles do not intersect\n");
            } else {
                for (Shape s : intersections) {
                    System.out.println("Intersection in: " + s);
                }
                System.out.println();
            }
        }
    }
}
