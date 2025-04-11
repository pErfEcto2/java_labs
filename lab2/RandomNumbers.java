package lab2;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {
    public static Integer get_random(ArrayList<Integer> arr) {
        Random rand = new Random();
        return arr.get(rand.nextInt(arr.size()));
    }

    public static int get_random(int[] arr) {
        Random rand = new Random();
        return arr[rand.nextInt(arr.length)];
    }
}
