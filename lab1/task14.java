package lab1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        String s = "";
        while (true) {
            s = scanner.nextLine().trim();
            if (s.isEmpty()) break;
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            ArrayList<String> ss = new ArrayList<String>(List.of(s.split(" ")));
            for (int i = 0; i < ss.size(); i++) {
                tmp.add(Integer.parseInt(ss.get(i)));
            }
            arr.add(tmp);
        }

        int res_sum = 0;
        for (int i = 0; i < arr.getFirst().size(); i++) res_sum += arr.getFirst().get(i);

        for (int i = 0; i < arr.size(); i++) {
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            int sum4 = 0;
            for (int j = 0; j < arr.get(i).size(); j++) {
                sum1 += arr.get(i).get(j);
                sum2 += arr.get(j).get(i);
                sum3 += arr.get(j).get(j);
                sum4 += arr.get(arr.size() - j - 1).get(j);
            }

            System.out.println(sum3 + " " + sum4);

            if (sum1 != res_sum || sum2 != res_sum || sum3 != res_sum || sum4 != res_sum) {
                System.out.println("it's not a magic square");
                return;
            }
        }
        System.out.println("it's a magic square");
    }
}
