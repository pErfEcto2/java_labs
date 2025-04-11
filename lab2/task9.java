package lab2;

import java.lang.Math;

class Car {
    private Point6 coordinates;
    private double fuel_level;
    private double fuel_consumption;

    public Car(double fuel_consumption, double fuel_level) {
        this.fuel_consumption = fuel_consumption;
        this.fuel_level = fuel_level;
        coordinates = new Point6(0, 0);
    }

    public void set_fuel_level(double fuel_level) {
        this.fuel_level = fuel_level;
    }

    public Point6 get_coordinates() {
        return coordinates;
    }

    public double get_fuel_level() {
        return fuel_level;
    }

    public double get_fuel_consumption() {
        return fuel_consumption;
    }

    private double count_distance(Point6 point1, Point6 point2) {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));
    }

    private boolean is_enough_fuel(double distance) {
        double available_distance = fuel_level / fuel_consumption;
        return available_distance >= distance;
    }

    public void drive(Point6 newPoint) {
        double distance = count_distance(coordinates, newPoint);
        if (is_enough_fuel(distance)) {
            coordinates.translate(newPoint.getX(), newPoint.getY());
            fuel_level -= distance * fuel_consumption;
        }
        else
            System.out.println("Not enough fuel");
    }

    public void drive(double x, double y) {
        drive(new Point6(x, y));
    }

    public void print() {
        System.out.println("consumption: " + fuel_consumption);
        System.out.println("fuel level: " + fuel_level);
        System.out.println("coordinates: " + coordinates);
    }
}


public class task9 {
    public static void main(String[] args) {
        Car c = new Car(1, 10);
        c.print();
        System.out.println();
        c.drive(5, 5);
        c.print();
        System.out.println();
        c.drive(new Point6(3, 3));
        c.print();
    }
}
