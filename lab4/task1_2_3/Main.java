package lab4.task1_2_3;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        LabeledPoint lp = new LabeledPoint("point", 1, 2);
        System.out.println(p1);
        System.out.println(lp);
        System.out.println(lp.equals(p1));
        System.out.println(lp.equals(lp));
        System.out.println(p1.equals(p2));
    }
}
