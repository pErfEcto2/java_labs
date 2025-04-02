package lab1;

import java.util.ArrayList;
import java.util.Scanner;


public class task15 {
    private static ArrayList<ArrayList<Integer>> calculate(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.getFirst().add(1);

        for (int i = 1; i < n; i++) {
            res.add(new ArrayList<>());
            res.getLast().add(1);
            for (int j = 0; j < i - 1; j++) {
                res.get(i).add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            }
            res.getLast().add(1);
        }
        return res;
    }

    public static void print(ArrayList<ArrayList<Integer>> arr) {
        int n = arr.size();
        int maxWidth = arr.get(n - 1).stream()
                .mapToInt(num -> Integer.toString(num).length()).sum()
                + arr.get(n - 1).size() - 1;

        for (int i = n - 1; i >= 0; i--) {
            ArrayList<Integer> row = arr.get(i);
            StringBuilder line = new StringBuilder();

            for (int num : row) {
                line.append(num).append(" ");
            }

            line.setLength(line.length() - 1);
            int padding = (maxWidth - line.length()) / 2;

            System.out.print(" ".repeat(padding));
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 1) {
            System.out.println("invalid number if rows");
            return;
        }
        ArrayList<ArrayList<Integer>> nums = calculate(n);
        print(nums);
    }
}
