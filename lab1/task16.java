package lab1;


public class task16 {
    public static double average(double ...values) {
        double res = 0;
        for (double val : values) {
            res += val;
        }
        return res / values.length;
    }

    public static double average() {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(average());
        System.out.println(average(10, 20, 30));
    }
}
