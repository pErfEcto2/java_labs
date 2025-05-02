package lab3;


import java.util.List;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.time.LocalDate;
import java.util.function.BiFunction;


public class task5_from_list {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Even elems from list " + numbers + " are:");
        numbers.stream()
                .filter(isEven)
                .forEach(System.out::println);

        Function<String, Integer> lengthFunc = String::length;
        String s = "test";
        System.out.print("\nLength of the string '" + s + "' is ");
        System.out.println(lengthFunc.apply(s));

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Consumer<String> printer = System.out::println;
        System.out.println("\nNames are: ");
        names.forEach(printer);

        Supplier<LocalDate> today = LocalDate::now;
        System.out.println("\nToday is " + today.get());

        BiFunction<Integer, Integer, Integer> adder = Integer::sum;
        Integer a = 5;
        Integer b = 3;
        System.out.println("\n" + a + " + " + b + " = " + adder.apply(a, b));
    }
}
