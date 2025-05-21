package lab4.task1_2_3;

import java.util.Objects;

public class LabeledPoint extends Point{
    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    @Override
    public String toString() {
        return "LabeledPoint['" + label + "', " + x + ", " + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        }

        LabeledPoint other = (LabeledPoint) obj;

        return label.equals(other.label) &&
                Double.compare(super.x, other.x) == 0 &&
                Double.compare(super.y, other.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.x, super.y, label);
    }
}
