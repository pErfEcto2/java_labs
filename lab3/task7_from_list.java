package lab3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

@FunctionalInterface
interface MyComparator<T> {
    int compare(T o1, T o2);

    default Comparator<T> toComparator() {
        return this::compare;
    }

    default MyComparator<T> reversed() {
        return (o1, o2) -> this.compare(o2, o1);
    }

    static <T extends Comparable<T>> MyComparator<T> naturalOrder() {
        return Comparable::compareTo;
    }

    static <T extends Comparable<T>> MyComparator<T> reverseOrder() {
        return (o1, o2) -> o2.compareTo(o1);
    }

    default MyComparator<T> thenComparing(MyComparator<T> other) {
        return (o1, o2) -> {
            int result = this.compare(o1, o2);
            return (result != 0) ? result : other.compare(o1, o2);
        };
    }

    // extract a field from an object
    static <T, U extends Comparable<? super U>> MyComparator<T> comparing(Function<? super T, ? extends U> keyExtractor) {
        return (o1, o2) -> keyExtractor.apply(o1).compareTo(keyExtractor.apply(o2));
    }

    // same but with specified comparator
    static <T, U> MyComparator<T> comparing(Function<? super T, ? extends U> keyExtractor, MyComparator<? super U> keyComparator) {
        return (o1, o2) -> keyComparator.compare(keyExtractor.apply(o1), keyExtractor.apply(o2));
    }

    // same but a field is an int
    static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        return (o1, o2) -> Integer.compare(keyExtractor.applyAsInt(o1), keyExtractor.applyAsInt(o2));
    }

    static <T> MyComparator<T> comparingLong(ToLongFunction<? super T> keyExtractor) {
        return (o1, o2) -> Long.compare(keyExtractor.applyAsLong(o1), keyExtractor.applyAsLong(o2));
    }

    static <T> MyComparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return (o1, o2) -> Double.compare(keyExtractor.applyAsDouble(o1), keyExtractor.applyAsDouble(o2));
    }

    static <T> MyComparator<T> nullsFirst(MyComparator<? super T> comparator) {
        return (o1, o2) -> {
            if (o1 == o2) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return comparator.compare(o1, o2);
        };
    }
    
    static <T> MyComparator<T> nullsLast(MyComparator<? super T> comparator) {
        return (o1, o2) -> {
            if (o1 == o2) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;
            return comparator.compare(o1, o2);
        };
    }
}

class Emp {
    private final String name;
    private final Integer age;

    public Emp(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee(name='" + name + "', age=" + age + ")";
    }
}

public class task7_from_list {
    public static void main(String[] args) {
        List<Emp> emps1 = Arrays.asList(
                new Emp("Alice", 30),
                new Emp("Bob", 25),
                new Emp("Charlie", 35),
                new Emp("David", 20),
                null,
                new Emp("Emely", null)
        );

        List<Emp> emps2 = Arrays.asList(
                new Emp("Alice", 30),
                new Emp("Bob", 25),
                new Emp("Charlie", 35),
                new Emp("David", 20),
                new Emp("Emely", 15),
                new Emp("Alice", 20)
        );


        System.out.println("Sorting by age ascending");
        sortAndPrint(emps2, MyComparator.comparing(Emp::getAge, MyComparator.naturalOrder()));

        System.out.println("\nSorting by age descending");
        sortAndPrint(emps2, MyComparator.comparing(Emp::getAge, MyComparator.reverseOrder()));

        System.out.println("\nSorting by age descending (other method)");
        sortAndPrint(emps2, MyComparator.comparing(Emp::getAge).reversed());

        System.out.println("\nSorting by name");
        sortAndPrint(emps2, MyComparator.comparing(Emp::getName));

        System.out.println("\nSorting by age and then by name");
        sortAndPrint(emps2, MyComparator.comparing(Emp::getAge).thenComparing(MyComparator.comparing(Emp::getName)));

        System.out.println("\nSorting ints");
        sortAndPrint(emps2, MyComparator.comparingInt(p -> p != null ? p.getAge() : 0));

        System.out.println("\nSorting doubles");
        sortAndPrint(emps2, MyComparator.comparingDouble(p -> p != null ? p.getAge() : 0));

        System.out.println("\nSorting longs");
        sortAndPrint(emps2, MyComparator.comparingLong(p -> p != null ? p.getAge() : 0));

        System.out.println("\nSorting with nulls first");
        sortAndPrint(emps1, MyComparator.nullsFirst(MyComparator.comparing(Emp::getName)));

        System.out.println("\nSorting with nulls last");
        sortAndPrint(emps1, MyComparator.nullsLast(MyComparator.comparing(Emp::getName)));

    }

    private static void sortAndPrint(List<Emp> l, MyComparator<Emp> comparator) {
        l.stream()
                .sorted(comparator.toComparator())
                .forEach(System.out::println);
    }

}
