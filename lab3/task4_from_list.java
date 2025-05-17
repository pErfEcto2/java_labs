package lab3;


/*
Отложенное выполнение (lazy evaluation) лямбда-выражений [ это стратегия, при которой код внутри лямбды
выполняется только в момент реального использования, а не при объявлении
 */

import java.util.function.Supplier;
import java.util.stream.Stream;

public class task4_from_list {
    public static void processIf(boolean condition, Runnable action) {
        if (condition) {
            action.run(); // Лямбда выполняется только при condition = true
        }
    }

    public static void main(String[] args) {
        // Экономия вычислительных ресурсов
        Supplier<String> lazyData = () -> {
            System.out.println("loading...");
            return "expensive db query";
        };
        boolean f = false;
        if (f) {
            String data = lazyData.get(); // Вычисление происходит здесь
        }


        /*
        Лямбды позволяют отделить определение логики от её выполнения, что полезно для:
            Настройки условий выполнения
            Динамического изменения поведения
         */
        processIf(!f, () -> System.out.println("hello"));

        /*
        Лямбды позволяют работать с потенциально бесконечными данными, так как элементы вычисляются «по требованию»
         */
        Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .limit(10)
                .forEach(fib -> System.out.print(fib[0] + " "));
    }
}
