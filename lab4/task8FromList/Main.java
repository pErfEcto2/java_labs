package lab4.task8FromList;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Получаем путь к директории с классами
        String classpath = Person.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath();


        URLClassLoader loader1 = new URLClassLoader(
                new URL[]{new File(classpath).toURI().toURL()},
                null // Важно: отключаем делегирование
        );

        URLClassLoader loader2 = new URLClassLoader(
                new URL[]{new File(classpath).toURI().toURL()},
                null
        );

        Class<?> personClass1 = loader1.loadClass("lab4.task8FromList.Person");
        Class<?> personClass2 = loader2.loadClass("lab4.task8FromList.Person");


        Object p1 = personClass1.getConstructor(String.class).newInstance("Alice");


        try {
            Object p2 = personClass2.cast(p1);
        } catch (ClassCastException e) {
            System.out.println("exception: \n" + e.getMessage());
        }
    }
}