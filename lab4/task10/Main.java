package lab4.task10;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<?> cl = double[].class;

        while (cl != null) {
            System.out.println("Class: " + cl.getCanonicalName());
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " " +
                        m.getReturnType().getCanonicalName() + " " +
                        m.getName() +
                        Arrays.toString(m.getParameters())
                );
            }
            System.out.println();
            cl = cl.getSuperclass();
        }
    }
}
