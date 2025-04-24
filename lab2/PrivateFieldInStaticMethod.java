package lab2;

public class PrivateFieldInStaticMethod {
    private String a = "private";

    public static String getA(PrivateFieldInStaticMethod other) {
        return other.a;
    }

    public static void main(String[] args) {
        PrivateFieldInStaticMethod other = new PrivateFieldInStaticMethod();
        System.out.println(getA(other));
        System.out.println(other.a);
    }
}
