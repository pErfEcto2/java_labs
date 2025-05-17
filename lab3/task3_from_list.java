package lab3;


/*
Функциональный интерфейс в Java получил своё название из-за своей способности представлять функцию как объект,
что позволяет работать с кодом в функциональном стиле
 */

import java.util.function.Function;

public class task3_from_list {
    public static void processNumber(int num, Function<Integer, Integer> func) {
        System.out.println(func.apply(num));
    }


    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x * x;
        System.out.println(square.apply(5));

        /*
        функциональные интерфейсы добавляют возможность:
            Передавать функции как аргументы
            Хранить функции в переменных
            Возвращать функции из методов
         */
        processNumber(3, x -> x + 1);

        /*
        Лямбда-выражения - это краткая форма записи анонимной реализации функционального интерфейса.
        Лямбда автоматически преобразуется в экземпляр интерфейса с одним методом
         */

        Runnable r1 = () -> System.out.println("Hello!");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        };

        r1.run();
        r2.run();
    }
}
