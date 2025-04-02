package lab1;

import java.util.Scanner;

public class task3 {
    public static int maxInt(int... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least one number must be provided");
        }

        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int res = a;

        if (b > res)
            res = b;
        if (c > res) res = c;

        System.out.println("max: " + res);
        System.out.println("max: " + Math.max(a, Math.max(b, c)));
        System.out.println("max: " + maxInt(a, b, c));
    }
}
