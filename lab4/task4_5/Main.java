package lab4.task4_5;

import lab4.task1_2_3.Point;

public class Main {
    public static void main(String[] args) {
        Circle original = new Circle(new Point(1, 2), 5);
        Circle copy = original.clone();

        System.out.println("original: " + original.getCentre());
        System.out.println("copy: " + copy.getCentre());

        original.moveBy(10, 10);

        System.out.println("\nafter original movement:");
        System.out.println("original: " + original.getCentre());
        System.out.println("copy: " + copy.getCentre());

        copy.moveBy(-10, -10);

        System.out.println("\nafter copy movement:");
        System.out.println("original: " + original.getCentre());
        System.out.println("copy: " + copy.getCentre());
    }
}
