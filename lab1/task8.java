package lab1;

import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String tmp = s.substring(i, j);

                if (!tmp.isEmpty()) System.out.println(tmp);
            }
        }
    }
}
