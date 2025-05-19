package lab3;


import java.util.Arrays;
import java.util.List;

interface MathOperations {
    static int add(int a, int b) {
        return a + b;
    }

}

interface MyList<T> {
    static <T> List<T> of(T... elements) {
        return Arrays.asList(elements);
    }
}

interface Logger {
    void log(String message);

    static boolean isDebugEnabled() {
        return System.getProperty("debug") != null;
    }
}

public class task2_from_list {
    public static void main(String[] args) {
        // Утилитарные методы (замена классов-помощников)
        // Раньше для таких методов создавали отдельные классы (например, MathUtils), теперь их можно размещать прямо в интерфейсе
        int res = MathOperations.add(1, 1);
        System.out.println("1 + 1 = " + res);

        // Фабричные методы
        List<String> immutableList = MyList.of("A", "B", "C");
        System.out.println("list is: " + immutableList);

        // Логика, связанная с интерфейсом
        if (Logger.isDebugEnabled()) {
            System.out.println("Debug mode is ON");
        } else {
            System.out.println("Debug mode is OFF");
        }
    }
}
