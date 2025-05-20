package lab4.task8FromList;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/*
Bootstrap ClassLoader (Корневой загрузчик)
    Роль: Загружает основные классы Java (пакеты java.*, javax.* и др.)
    Реализация: Нативный код, часть JVM
    Особенности:
        Самый привилегированный загрузчик
        Загружает классы из rt.jar и других основных библиотек
        Не имеет родительского загрузчика (вершина иерархии)
        Не видим из Java-кода (возвращает null для getParent())

2. Platform ClassLoader
    Роль: Загружает классы расширений Java
    Родитель: Bootstrap ClassLoader
    Особенности:
        В Java 8 назывался Extension ClassLoader
        Загружает классы из каталога расширений ($JAVA_HOME/lib/ext)
        В Java 9+ загружает модули платформы

3. System/Application ClassLoader
    Роль: Загружает классы приложения из classpath
    Родитель: Platform ClassLoader
    Особенности:
        Также называется AppClassLoader
        Загружает классы из пути, указанного в -classpath или CLASSPATH
        Основной загрузчик, используемый по умолчанию

Принцип делегирования (Delegation Model)
Java использует модель делегирования при загрузке классов:
    Когда загрузчик получает запрос на загрузку класса:
        Сначала проверяет, не был ли класс уже загружен
        Если нет - делегирует запрос родительскому загрузчику
        Только если родители не смогли загрузить класс, пытается загрузить его сам
    Это обеспечивает:
        Безопасность (предотвращает подмену системных классов)
        Уникальность (класс загружается только один раз)
        Предсказуемость (системные классы имеют приоритет)
 */

public class Main {
    public static void main(String[] args) throws Exception {
        // Получаем путь к директории с классами
        String classpath = Person.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath();


        /*
        Каждый URLClassLoader становится корневым в своей собственной иерархии ->
        загрузчики не делегируют загрузку классов родительскому загрузчику
        Даже при загрузке одного и того же .class файла, разные загрузчики создают разные объекты Class

        Без null (по умолчанию):
            URLClassLoader делегирует загрузку системному загрузчику (AppClassLoader)
            Если класс уже загружен родительским загрузчиком, будет использована существующая версия
            Все загрузчики в итоге используют один объект Class
         */
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