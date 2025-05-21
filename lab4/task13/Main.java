package lab4.task13;


import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

public class Main {
    public static void printTable(Method method, double lowerBound, double upperBound, double step) throws Exception {
        System.out.println(String.format("%-10s", "x") + "| " + String.format("%-10s", method.getName() + "(x)"));
        System.out.println("-".repeat(30));

        for (double x = lowerBound; x <= upperBound; x += step) {
            Object result = method.invoke(null, x);
            System.out.println(String.format("%-10s", x) + "| " + String.format("%-10s", result));
        }
    }

    public static void printTable(DoubleFunction<Object> function, double lowerBound, double upperBound, double step) {
        System.out.println(String.format("%-10s", "x") + "| " + String.format("%-10s", "f(x)"));
        System.out.println("-".repeat(30));

        for (double x = lowerBound; x <= upperBound; x += step) {
            Object result = function.apply(x);
            System.out.println(String.format("%-10s", x) + "| " + String.format("%-10s", result));
        }
    }

    public static void main(String[] args) throws Exception {
        /*
        Безопасность
            Reflection
                Ошибки обнаруживаются только в runtime
                Может вызывать private методы (нарушает принципы инкапсуляции)

            DoubleFunction
                Полная проверка типов на этапе компиляции
                Полностью соблюдает инкапсуляцию

        Эффективность
            Reflection
                Медленнее
                Потребление памяти выше

            DoubleFunction
                Быстрее
                Меньшее потребление памяти

        Удобство
            Reflection
                Код сложнее
                Гибкость выше (можно вызывать любые методы динамически)

            DoubleFunction
                Код проще
                Ограничен функциональными интерфейсами
         */

        // reflection
        Method sqrtMethod = Math.class.getMethod("sqrt", double.class);
        System.out.println("Math.sqrt (reflection):");
        printTable(sqrtMethod, 0, 10, 1);

        Method toHexStringMethod = Double.class.getMethod("toHexString", double.class);
        System.out.println("\nDouble.toHexString (reflection):");
        printTable(toHexStringMethod, 0, 10, 1);

        // DoubleFunction
        DoubleFunction<Object> sqrtFunction = Math::sqrt;
        System.out.println("\n\nMath.sqrt (DoubleFunction):");
        printTable(sqrtFunction, 0, 10, 1);

        DoubleFunction<Object> toHexStringFunction = Double::toHexString;
        System.out.println("\nDouble.toHexString (DoubleFunction):");
        printTable(toHexStringFunction, 0, 10, 1);

    }
}