package lab3;


import java.util.Arrays;
import java.util.Comparator;

public class task14 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("employee 1", 1),
                new Employee("employee 2", 2),
                new Employee("employee 3", 3)
        };

        Arrays.sort(employees, Comparator
                .comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
        );

        System.out.println("Сортировка по зарплате и имени:");
        Arrays.stream(employees).forEach(System.out::println);

        Arrays.sort(employees, Comparator
                .comparing(Employee::getSalary)
                .thenComparing(Employee::getName)
                .reversed()
        );

        System.out.println("\nСортировка в обратном порядке:");
        Arrays.stream(employees).forEach(System.out::println);
    }
}
