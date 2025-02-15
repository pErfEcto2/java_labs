package lab1;

import java.util.ArrayList;
import java.util.Scanner;


public class task15 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        res.getFirst().add(1);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 1) {
            System.out.println(res);
            return;
        }

        for (int i = 1; i < n; i++) {
            res.add(new ArrayList<Integer>());
            res.getLast().add(1);
            for (int j = 0; j < i - 1; j++) {
                res.get(i).add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            }
            res.getLast().add(1);
        }
        System.out.println(res);
    }
}
