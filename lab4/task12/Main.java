package lab4.task12;

import java.io.PrintStream;
import java.lang.reflect.Method;

public class Main {
    public static void func() {
        for (int i = 0; i < 1_000_000; i++) {
            double a = Math.sqrt(i);
        }
    }

    public static void reflectionFunc() throws Exception {
        Class<?> mainClass = Class.forName("lab4.task12.Main");
        Method funcMethod = mainClass.getDeclaredMethod("func");
        funcMethod.invoke(null);
    }

    public static void main(String[] args) throws Exception {
        int n = 10_000_000;

        long start = System.currentTimeMillis();
        PrintStream out = System.out;
        for (int i = 0; i < n; i++) {
            func();
        }
        long end = System.currentTimeMillis();
        long timeNormal = end - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            reflectionFunc();
        }
        end = System.currentTimeMillis();

        long timeReflection = end - start;

        System.out.println("timeNormal: " + timeNormal + "ms");
        System.out.println("timeReflection: " + timeReflection + "ms");
        System.out.println("timeReflection - timeNormal = " + (timeReflection - timeNormal) + "ms");
    }
}