package lab2;

import java.util.ArrayList;

public final class Rectangle {
    private final Point5 bottomLeft;
    private final Point5 topRight;

    public Rectangle(Point5 bottomLeft, Point5 topRight) {
        if (bottomLeft == null || topRight == null) {
            throw new IllegalArgumentException("Points cannot be null");
        }
        if (bottomLeft.getX() > topRight.getX() || bottomLeft.getY() > topRight.getY()) {
            throw new IllegalArgumentException("Invalid rectangle coordinates");
        }
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Rectangle(Point5 bottomLeft, double width, double height) {
        this(bottomLeft, new Point5(bottomLeft.getX() + width, bottomLeft.getY() + height));
    }

    public Point5 getBottomLeft() {
        return bottomLeft;
    }

    public Point5 getTopRight() {
        return topRight;
    }

    public double getWidth() {
        return topRight.getX() - bottomLeft.getX();
    }

    public double getHeight() {
        return topRight.getY() - bottomLeft.getY();
    }

    public boolean intersects(Rectangle other) {
        return bottomLeft.getX() < other.topRight.getX() &&
                topRight.getX() > other.bottomLeft.getX() &&
                bottomLeft.getY() < other.topRight.getY() &&
                topRight.getY() > other.bottomLeft.getY();
    }

    public ArrayList<Point5> findIntersectionPoints(Rectangle other) {
        ArrayList<Point5> intersectionPoints = new ArrayList<>();

        if (!this.intersects(other)) {
            return intersectionPoints;
        }

        double left = Math.max(bottomLeft.getX(), other.bottomLeft.getX());
        double right = Math.min(topRight.getX(), other.topRight.getX());
        double bottom = Math.max(bottomLeft.getY(), other.bottomLeft.getY());
        double top = Math.min(topRight.getY(), other.topRight.getY());

        intersectionPoints.add(new Point5(left, bottom));
        intersectionPoints.add(new Point5(left, top));
        intersectionPoints.add(new Point5(right, bottom));
        intersectionPoints.add(new Point5(right, top));

        return intersectionPoints;
    }

    @Override
    public String toString() {
        return "Rectangle[(" + bottomLeft.getX() + "," + bottomLeft.getY() +
                "), (" + topRight.getX() + "," + topRight.getY() + ")]";
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(new Point5(0, 0), new Point5(4, 4));
        Rectangle rect2 = new Rectangle(new Point5(2, 2), new Point5(6, 6));

        ArrayList<Point5> intersections = rect1.findIntersectionPoints(rect2);

        if (intersections.isEmpty()) {
            System.out.println("Rectangles do not intersect");
        } else {
            System.out.println("Rectangles intersect in:");
            System.out.println("Bottom left point: " + intersections.getFirst());
            System.out.println("Top left point: " + intersections.get(1));
            System.out.println("Bottom right point: " + intersections.get(2));
            System.out.println("Top right point: " + intersections.getLast());
        }
    }
}