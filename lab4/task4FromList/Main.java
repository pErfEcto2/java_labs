package lab4.task4FromList;


/*
Основные требования к equals()
    Рефлексивность: x.equals(x) → true.
    Симметричность: x.equals(y) → y.equals(x).
    Транзитивность: x.equals(y) и y.equals(z) → x.equals(z).
    Консистентность: Многократный вызов equals() должен возвращать одно и то же значение.
    Сравнение с null: x.equals(null) → false.

Проблема при использовании instanceof:
    Если в родительском классе equals() использует instanceof,
        то при наследовании может нарушиться симметричность и транзитивность
 */

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        ColoredPoint p2 = new ColoredPoint(1, 2, "red");

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p1));
    }
}
