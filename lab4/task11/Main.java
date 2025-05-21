package lab4.task11;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> systemClass = Class.forName("java.lang.System");

        Field outField = systemClass.getDeclaredField("out");
        outField.setAccessible(true);

        // null because of out is static
        Object printStream = outField.get(null);

        Class<?> printStreamClass = Class.forName("java.io.PrintStream");
        Method printlnMethod = printStreamClass.getDeclaredMethod("println", String.class);

        printlnMethod.invoke(printStream, "Hello, World");
    }
}
