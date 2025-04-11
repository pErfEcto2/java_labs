package lab2;

import java.time.LocalDate;
import static java.time.DayOfWeek.*;
import static java.time.DayOfWeek.of;
import static java.time.LocalDate.of;

public class task1 {
    private static void print_days(LocalDate date) {
        for (int i = 1; i < date.getDayOfWeek().getValue() + 1; i++)
            System.out.print("    ");

        while (date.getMonthValue() == LocalDate.now().getMonthValue()) {
            if (date.getDayOfWeek() == SUNDAY)
                System.out.println();
            System.out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1);
        }
    }

    private static void show_weekdays() {
        for (int i = 0; i < 7; i++)
            System.out.printf("%4s", of((i + 6) % 7 + 1).toString().substring(0, 3));
        System.out.println();
    }

    public static void main(String[] args) {
        LocalDate date = of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 1);
        show_weekdays();
        print_days(date);
    }
}
