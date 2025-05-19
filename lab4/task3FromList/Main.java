package lab4.task3FromList;


import java.util.HashSet;
import java.util.Set;

/*
Контракт equals() и hashCode():
    Если два объекта равны по equals() -> их hashCode() должен быть одинаковым
        Но обратное необязательно: разные объекты могут иметь одинаковый hashCode() (коллизия)
    Если hashCode() разный → объекты точно разные
    Метод hashCode() должен возвращать одно и то же значение для одного и того же объекта (если его состояние не меняется)

Что будет, если нарушить контракт?
    Неправильная работа HashSet, HashMap и других коллекций, использующих хеширование
        (сначала проверяют hashCode(), и если хеши разные → объекты считаются разными)
    Объекты, которые должны считаться одинаковыми, могут потеряться или дублироваться
 */

public class Main {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Alice", 25);

        System.out.println(p1.equals(p2));

        people.add(p1);
        people.add(p2);

        System.out.println(people.size());
    }
}
