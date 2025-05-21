package lab4.task7;

public enum Color {
    BLACK(0, 0, 0),
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    CYAN(0, 255, 255),
    MAGENTA(255, 0, 255),
    YELLOW(255, 255, 0),
    WHITE(255, 255, 255);

    private final int red;
    private final int green;
    private final int blue;

    Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}