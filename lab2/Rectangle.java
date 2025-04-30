package lab2;

import java.util.ArrayList;
import lab2.Point5;


/**
 * Represents a rectangle defined by two diagonal points
 */
public class Rectangle {
    /** Bottom-left point of the rectangle */
    private final Point5 bottomLeft;
    /** Top-right point of the rectangle */
    private final Point5 topRight;

    /**
     * Creates rectangle from any two diagonal points
     * @param p1 first diagonal point
     * @param p2 second diagonal point
     */
    public Rectangle(Point5 p1, Point5 p2) {
        double minX = Math.min(p1.getX(), p2.getX());
        double minY = Math.min(p1.getY(), p2.getY());
        double maxX = Math.max(p1.getX(), p2.getX());
        double maxY = Math.max(p1.getY(), p2.getY());

        this.bottomLeft = new Point5(minX, minY);
        this.topRight = new Point5(maxX, maxY);
    }

    /**
     * Gets bottom-left point
     * @return bottom-left point
     */
    public Point5 getBottomLeft() {
        return bottomLeft;
    }

    /**
     * Gets top-right point
     * @return top-right point
     */
    public Point5 getTopRight() {
        return topRight;
    }

    /**
     * Checks if this rectangle intersects with another
     * @param other rectangle to check
     * @return true if rectangles intersect
     */
    public boolean intersects(Rectangle other) {
        return !(this.topRight.getX() < other.bottomLeft.getX() ||
                this.bottomLeft.getX() > other.topRight.getX() ||
                this.topRight.getY() < other.bottomLeft.getY() ||
                this.bottomLeft.getY() > other.topRight.getY());
    }

    /**
     * Finds intersection points between this rectangle and another
     * @param other the other rectangle to check against
     * @return ArrayList of intersection points (0, 1, or 2 points)

     */
    public ArrayList<Point5> getIntersectionPoints(Rectangle other) {
        ArrayList<Point5> points = new ArrayList<>();

        if (!this.intersects(other)) {
            return points;
        }

        Point5[] thisEdges = getEdges();
        Point5[] otherEdges = other.getEdges();

        for (int i = 0; i < thisEdges.length; i += 2) {
            loop:
            for (int j = 0; j < otherEdges.length; j += 2) {
                Point5 intersection = findLineIntersection(
                        thisEdges[i], thisEdges[i+1],
                        otherEdges[j], otherEdges[j+1]
                );

                if (intersection == null) {
                    continue;
                }

                for (Point5 p : points) {
                    if (p.getX() == intersection.getX() && p.getY() == intersection.getY()) {
                        continue loop;
                    }
                }

                points.add(intersection);
            }
        }

        return points;
    }

    /**
     * Helper method to get all edges of the rectangle as point pairs
     * @return array of points representing edges (p1, p2, p3, p4, ...)
     */
    private Point5[] getEdges() {
        Point5 bottomRight = new Point5(topRight.getX(), bottomLeft.getY());
        Point5 topLeft = new Point5(bottomLeft.getX(), topRight.getY());

        return new Point5[] {
                bottomLeft, bottomRight,
                bottomRight, topRight,
                topRight, topLeft,
                topLeft, bottomLeft
        };
    }

    /**
     * Finds intersection point of two lines
     * Each line is represented by two distinct points
     *
     * @param line1P1 first point of line 1
     * @param line1P2 second point of line 1
     * @param line2P1 first point of line 2
     * @param line2P2 second point of line 2
     * @return intersection point or null if lines don't intersect
     */
    public static Point5 findLineIntersection(Point5 line1P1, Point5 line1P2,
                                              Point5 line2P1, Point5 line2P2) {
        double x1 = line1P1.getX(), y1 = line1P1.getY();
        double x2 = line1P2.getX(), y2 = line1P2.getY();
        double x3 = line2P1.getX(), y3 = line2P1.getY();
        double x4 = line2P2.getX(), y4 = line2P2.getY();

        double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);

        if (denom == 0) {
            return null;
        }

        double a = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / denom;
        double b = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / denom;

        if (a >= 0 && a <= 1 && b >= 0 && b <= 1) {
            double x = x1 + a * (x2 - x1);
            double y = y1 + a * (y2 - y1);
            return new Point5(x, y);
        }

        return null;
    }

    @Override
    public String toString() {
        return "Rectangle[" + bottomLeft + " to " + topRight + "]";
    }


    public static void main(String[] args) {
        ArrayList<Rectangle> rects = new ArrayList<>();
        rects.add(new Rectangle(new Point5(0, 0), new Point5(4, 4)));
        rects.add( new Rectangle(new Point5(2, 2), new Point5(6, 6)));
        rects.add( new Rectangle(new Point5(10, 10), new Point5(15, 15)));
        rects.add( new Rectangle(new Point5(-1, -1), new Point5(0, 0)));
        rects.add(new Rectangle(new Point5(-1, 1), new Point5(7, 3)));
        rects.add(new Rectangle(new Point5(0, 0), new Point5(4, 2)));

        for (int i = 1; i < 6; i++) {
            System.out.println("Checking 1 and " + (i + 1) + " rects");
            ArrayList<Point5> intersections = rects.getFirst().getIntersectionPoints(rects.get(i));

            if (intersections.isEmpty()) {
                System.out.println("1 and " + (i + 1) + " rectangles do not intersect\n");
            } else {
                for (Point5 p : intersections) {
                    System.out.println("Intersection in: " + p);
                }
                System.out.println();
            }
        }
    }
}