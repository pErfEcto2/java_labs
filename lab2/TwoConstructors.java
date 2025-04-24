package lab2;

public class TwoConstructors {
    private int value;

    private TwoConstructors(int value) {  // Приватный конструктор
        this.value = value;
    }

    public static TwoConstructors createDefault(int value) {
        return new TwoConstructors(value);
    }

    public static TwoConstructors createDoubled(int value) {
        return new TwoConstructors(value * 2);
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        TwoConstructors one = TwoConstructors.createDefault(1);
        TwoConstructors two = TwoConstructors.createDoubled(1);
        System.out.println(one.getValue());
        System.out.println(two.getValue());
    }
}
