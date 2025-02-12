package lab1;

import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if ((char) s1.charAt(i) - (char) s2.charAt(i) != 0) {
                System.out.println("not equal");
                return;
            }
        }
        System.out.println("equal");
    }
}
