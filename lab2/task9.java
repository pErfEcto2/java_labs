package lab2;

import java.lang.Math;

class Car {
    private Point6 coordinates;
    private double fuelLevel;
    private final  double fuelConsumption;

    public Car(double fuelConsumption, double fuelLevel) {
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = fuelLevel;
        coordinates = new Point6(0, 0);
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Point6 getCoordinates() {
        return coordinates;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    private double countDistance(Point6 point1, Point6 point2) {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));
    }

    private boolean isEnoughFuel(double distance) {
        return fuelLevel / fuelConsumption >= distance;
    }

    public void driveTo(Point6 newPoint) {
        double distance = countDistance(coordinates, newPoint);
        if (isEnoughFuel(distance)) {
            coordinates = newPoint;
            fuelLevel -= distance * fuelConsumption;
        }
        else
            System.out.println("Not enough fuel");
    }

    public void driveTo(double x, double y) {
        driveTo(new Point6(x, y));
    }

    @Override
    public String  toString() {
        return "fuel level: " + fuelLevel + "\ncoordinates: " + coordinates;
    }
}


public class task9 {
    public static void main(String[] args) {
        Car car = new Car(1, 10);
        System.out.println(car + "\n");

        car.driveTo(new Point6(1, 1));
        System.out.println(car + "\n");

        car.driveTo(new Point6(2, 2));
        System.out.println(car + "\n");

        car.driveTo(new Point6(100, 100));
        System.out.println(car + "\n");

        car.setFuelLevel(10);
        System.out.println(car + "\n");

        car.driveTo(new Point6(-1, -1));
        System.out.println(car + "\n");

        car.driveTo(new Point6(-3, -3));
        System.out.println(car + "\n");

        car.driveTo(new Point6(-100, -100));
        System.out.println(car + "\n");
    }
}
