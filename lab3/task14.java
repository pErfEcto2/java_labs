package lab3;


import java.util.Arrays;
import java.util.Comparator;

public class task14 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("employee 3", 2),
                new Employee("employee 3", 1),
                new Employee("employee 2", 2),
                new Employee("employee 2", 3)
        };

        System.out.println("Before sorting: ");
        Arrays.stream(employees).forEach(System.out::println);

        Arrays.sort(employees, Comparator
                .comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
        );

        System.out.println("\nAfter sorting:");
        Arrays.stream(employees).forEach(System.out::println);

        Arrays.sort(employees, Comparator
                .comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
                .reversed()
        );

        System.out.println("\nAfter reverse sorting:");
        Arrays.stream(employees).forEach(System.out::println);
    }
}
