package lab3;


import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;

public class task6_from_list {
    public static void main(String[] args) {
        // Ссылка на статический метод
        Function<Integer, Double> converter2 = Math::sqrt;
        System.out.println(converter2.apply(25));

        // Ссылка на конструктор
        Supplier<List<String>> lambda1 = ArrayList::new;
        List<String> list = lambda1.get();
        list.add("1");
        list.add("2");
        System.out.println(list);

        // Ссылка на метод произвольного объекта
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.stream().map(String::length).forEach(x -> System.out.print(x + " "));

        // Ссылка на метод экземпляра
        String greeting = "Hello";
        Supplier<String> lambda2 = greeting::toUpperCase;
        System.out.println("\n" + lambda2.get());
    }
}
