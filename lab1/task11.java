package lab1;

import java.util.Scanner;

public class task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c > 127)
                System.out.println((char)c + " " + c);
        }
    }
}
