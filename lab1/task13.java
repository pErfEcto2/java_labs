package lab1;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class task13 {
    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(1, 49).toArray();
        ArrayList<Integer> res = new ArrayList<Integer>();
        Random rand = new Random();
        int r;

        for (int i = 0; i < 6; i++) {
            do {
                r = rand.nextInt(49);
            }
            while (arr[r] == 0);
            res.add(arr[r]);
            arr[r] = 0;
        }
        res.sort(null);
        System.out.println(res);
    }
}
