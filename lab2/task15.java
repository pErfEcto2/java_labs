package lab2;

import java.util.ArrayList;

class Invoice {
    public static class Item {
        private String description;
        private int quantity;
        private double unitPrice;

        public Item(String description, int quantity, double unitPrice) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public double price() { return quantity * unitPrice; }
    }

    private ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public void addItem(String description, int quantity, double unitPrice) {
        Item newltem = new Item(description, quantity, unitPrice);
        newltem.description = description;
        newltem.quantity = quantity;
        newltem.unitPrice = unitPrice;
        items.add(newltem);
    }

    public void print() {
        System.out.println("Items:");
        for (Item item : items) {
            System.out.printf("%s: %d x $%.2f = $%.2f%n",
                    item.description,
                    item.quantity,
                    item.unitPrice,
                    item.price());
        }
        double total = items.stream().mapToDouble(Item::price).sum();
        System.out.printf("Total: $%.2f%n", total);
    }
}

public class task15 {
    public static void main(String[] args) {
        Invoice a = new Invoice();
        a.addItem("test", 5, 5);
        a.addItem("test2", 3, 3);
        a.print();
    }
}