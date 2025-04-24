package lab2;


import java.lang.Math;
import lab2.Point6;

/**
 * Represents a car with fuel consumption and position
 */
class Car {
    private Point6 coordinates; // Current coordinates of the car
    private double fuelLevel; // Current amount of fuel in the car
    private final double fuelConsumption; // Fuel consumption rate (units per distance)

    /**
     * Creates a new Car with specified fuel consumption and level
     * @param fuelConsumption the car's fuel consumption rate
     * @param fuelLevel the initial fuel amount
     */
    public Car(double fuelConsumption, double fuelLevel) {
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = fuelLevel;
        coordinates = new Point6(0, 0);
    }

    /**
     * Sets the car's fuel level
     * @param fuelLevel the new fuel amount
     */
    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    /**
     * Gets the car's current coordinates
     * @return the current location
     */
    public Point6 getCoordinates() {
        return coordinates;
    }

    /**
     * Gets the car's current fuel level
     * @return the remaining fuel amount
     */
    public double getFuelLevel() {
        return fuelLevel;
    }

    /**
     * Gets the car's fuel consumption rate
     * @return the fuel consumption
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Calculates distance between two points
     * @param point1 first point
     * @param point2 second point
     * @return the distance between points
     */
    private double countDistance(Point6 point1, Point6 point2) {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));
    }

    /**
     * Checks if there's enough fuel for a given distance
     * @param distance the distance to check
     * @return true if enough fuel, false otherwise
     */
    private boolean isEnoughFuel(double distance) {
        return fuelLevel / fuelConsumption >= distance;
    }

    /**
     * Attempts to drive the car to a new location
     * @param newPoint the destination coordinates
     */
    public void driveTo(Point6 newPoint) {
        double distance = countDistance(coordinates, newPoint);
        if (isEnoughFuel(distance)) {
            coordinates = newPoint;
            fuelLevel -= distance * fuelConsumption;
        }
        else
            System.out.println("Not enough fuel");
    }

    /**
     * Attempts to drive the car to new coordinates
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public void driveTo(double x, double y) {
        driveTo(new Point6(x, y));
    }

    /**
     * Returns a string representation of the car's status
     * @return string with fuel level and coordinates
     */
    @Override
    public String toString() {
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
