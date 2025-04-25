package lab3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class task7 {
    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        ArrayList<String> sortedCopy = new ArrayList<>(strings);

        sortedCopy.sort(comp);

        while (!strings.equals(sortedCopy)) {
            Collections.shuffle(strings);
        }
    }


    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        int n = 5;

        for (int i = 0; i < n; i++)
            arr.add(Integer.valueOf(n - i).toString());

        System.out.println("Before sorting: " + arr);
        luckySort(arr, Comparator.naturalOrder());
        System.out.println("After sorting: " + arr);
    }
}