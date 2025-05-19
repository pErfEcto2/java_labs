package lab4.task4FromList;


public class ColoredPoint extends Point {
    private String color;

    public ColoredPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColoredPoint)) return false;
        ColoredPoint cp = (ColoredPoint) o;
        return super.equals(cp) && color.equals(cp.color);
    }
     */
}
