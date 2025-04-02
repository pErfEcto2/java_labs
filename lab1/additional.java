package lab1;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class additional {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write words divided by spaces");
        String inputLine = scanner.nextLine();

        String[] input = inputLine.split("\s+");

        List<List<String>> result = groupAnagrams(input);

        System.out.println("Result:");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}