package lab4.task12;

import java.io.PrintStream;
import java.lang.reflect.Method;

public class Main {
    public static void print() {
        System.out.println("Hello, World");
    }

    public static void reflectionPrint() throws Exception {
        Class<?> printStreamClass = Class.forName("java.io.PrintStream");
        Method printlnMethod = printStreamClass.getDeclaredMethod("println", String.class);
        Object printStream = System.out;
        printlnMethod.invoke(printStream, "Hello, World");
    }

    public static void main(String[] args) throws Exception {
        int n = 1_000_000;

        long start = System.currentTimeMillis();
        PrintStream out = System.out;
        for (int i = 0; i < n; i++) {
            print();
        }
        long end = System.currentTimeMillis();
        long timeNormal = end - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            reflectionPrint();
        }
        end = System.currentTimeMillis();

        long timeReflection = end - start;

        System.out.println("timeNormal: " + timeNormal + "ms");
        System.out.println("timeReflection: " + timeReflection + "ms");
        System.out.println("timeReflection - timeNormal = " + (timeReflection - timeNormal) + "ms");
    }
}