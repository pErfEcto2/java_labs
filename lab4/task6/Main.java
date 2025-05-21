package lab4.task6;

public class Main {
    public static void main(String[] args) {
        Item item = new Item("laptop", 10.0);
        DiscountedItem dItem1 = new DiscountedItem("laptop", 10.0, 1.0);
        DiscountedItem dItem2 = new DiscountedItem("laptop", 10.0, 2.0);

        // symmetry
        System.out.println("\nitem.equals(dItem1): " + item.equals(dItem1));
        System.out.println("dItem1.equals(item): " + dItem1.equals(item));

        // transitivity
        System.out.println("\nitem.equals(dItem1): " + item.equals(dItem1));
        System.out.println("dItem1.equals(dItem2): " + dItem1.equals(dItem2));
        System.out.println("item.equals(dItem2): " + item.equals(dItem2));

    }
}
