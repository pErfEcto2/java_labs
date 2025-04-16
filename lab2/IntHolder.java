package lab2;

public class IntHolder {
    private int number;
    public IntHolder() {
        number = 0;
    }
    public IntHolder(int number) {
        number = number;
    }
    public IntHolder setNumber(int value) {
        number = value;
        return this;
    }
    public int getNumber() {
        return number;
    }
    public void swap(IntHolder intHolder) {
        int tmp = intHolder.number;
        intHolder.number = number;
        number = tmp;
    }
    public static void main(String[] args) {
        IntHolder a = new IntHolder(3);
        IntHolder b = new IntHolder(5);
        a.swap(b);
        System.out.println(a.getNumber());
        System.out.println(b.getNumber());
    }
}
