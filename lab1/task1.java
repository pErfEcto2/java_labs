package lab1;


public class task1 {
    public static void main(String[] args) {
        int a = Integer.parseInt(System.console().readLine());
        System.out.println("bin: " + Integer.toBinaryString(a));
        System.out.println("oct: " + Integer.toOctalString(a));
        System.out.println("hex: " + Integer.toHexString(a));
        System.out.println(Float.toHexString((float) 1 / a));
    }
}
