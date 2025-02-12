package lab1;

import java.util.Scanner;

public class task3 {
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
    }
}
