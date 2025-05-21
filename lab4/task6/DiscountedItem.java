package lab4.task6;


import java.util.Objects;

public class DiscountedItem extends Item{
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Item)) return false;

        if (!(obj instanceof DiscountedItem)) {
            return super.equals(obj);
        }

        DiscountedItem other = (DiscountedItem) obj;

        return super.equals(other) &&
                Double.compare(other.discount, discount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.description, super.price, discount);
    }
}
