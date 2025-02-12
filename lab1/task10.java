package lab1;

import java.util.Random;
import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int n = scanner.nextInt();
        String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
        String res = "";
        for (int i = 0; i < n; i++) {
            res += alphabet.charAt((int)rand.nextLong(37));
        }
        System.out.println(res);
    }
}
