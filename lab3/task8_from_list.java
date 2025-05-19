package lab3;


interface Greeter2 {
    void greet();
    void setName(String name);
}

interface Printer {
    void print(String text);
}

class ConsolePrinter implements Printer {
    private String prefix;

    public ConsolePrinter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void print(String text) {
        System.out.println(prefix + text);
    }
}

public class task8_from_list {
    public static void main(String[] args) {
        /*
        Анонимный класс
        Нужно переопределить несколько методов интерфейса/класса
        Требуется доступ к полям внешнего класса (включая private)

        Плюсы:
            Можно реализовать интерфейсы с несколькими методами
            Можно добавить дополнительные поля и методы

        Минусы:
            Многословный синтаксис
            Создает отдельный .class-файл при компиляции
         */
        Greeter2 anonymousGreeter = new Greeter2() {
            private String name;

            @Override
            public void greet() {
                System.out.println("Anonymous hello, " + name);
            }

            @Override
            public void setName(String name) {
                this.name = name;
            }
        };

        anonymousGreeter.setName("perfecto");
        anonymousGreeter.greet();



        /*
        Лямбда-выражения
        Когда использовать:
            Нужна простая реализация одного метода
            Работа с Stream API, коллекциями, многопоточностью

        Плюсы:
            Лаконичный синтаксис
            Нет накладных расходов на создание класса
            Лучшая интеграция с Stream API

        Минусы:
            Работает только с функциональными интерфейсами
            Нельзя добавить поля или методы
         */
        Printer lambdaPrinter = text -> System.out.println("Lambda: " + text);
        lambdaPrinter.print("test");




        /*
        Обычные классы
        Когда использовать:
            Нужна многократная переиспользуемость
            Требуется сложная логика с множеством методов

        Плюсы:
            Полная гибкость (поля, методы, наследование)
            Можно тестировать и переиспользовать
            Поддержка инкапсуляции и полиморфизма

        Минусы:
            Требует больше кода
            Избыточен для простых задач
         */
        Printer customPrinter = new ConsolePrinter("Custom: ");
        customPrinter.print("Hello");
    }
}
