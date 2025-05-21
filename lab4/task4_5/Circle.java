package lab4.task4_5;


import lab4.task1_2_3.Point;

public class Circle extends Shape{
    private final double radius;

    public Circle(Point centre, double radius) {
        super(centre);
        this.radius = radius;
    }

    @Override
    public Circle clone() {
        return (Circle) super.clone();
    }
}
