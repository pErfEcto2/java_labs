package lab4.task9_from_list;

import java.lang.reflect.Proxy;
import java.util.ServiceLoader;

/*
ServiceLoader - это механизм для динамической загрузки реализаций интерфейсов

Зачем нужен?
    Позволяет подключать реализации без явного указания классов в коде (плагины и расширения)
    Новые реализации можно добавлять просто добавлением файла в META-INF/services/
 */


public class Main {
    public static void main(String[] args) {
        ServiceLoader<GreetingService> loader =
                ServiceLoader.load(GreetingService.class);

        System.out.println("Available greeting services:");

        for (GreetingService service : loader) {
            System.out.println(service.greet("perfecto"));
        }

        System.out.println();

        /*
            Интерфейс (GreetingService) - определяет методы, которые можно проксировать
            Реальный объект (GreetingService1) - реализация
            InvocationHandler перехватывает вызовы методов и добавляет логирование
            Proxy.newProxyInstance() - создает прокси-объект
            Прокси подменяет вызовы методов, делегируя их обработчику
         */

        GreetingService realGreeter = new GreetingService1();

        GreetingService proxyGreeter = (GreetingService) Proxy.newProxyInstance(
                GreetingService.class.getClassLoader(), // class loader
                new Class<?>[] { GreetingService.class }, // interface list
                new LoggingHandler(realGreeter) // handler
        );

        System.out.println(proxyGreeter.greet("Алиса"));
    }
}