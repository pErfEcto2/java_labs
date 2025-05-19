package lab4.task1FromList;


/*
Проверка на корректность переопределения:
    Если метод с @Override не переопределяет никакой метод суперкласса или интерфейса, компилятор выдаст ошибку
    Это помогает избежать опечаток в имени метода или ошибок в сигнатуре

Улучшение читаемости кода:
    Показывает, что метод является переопределённым, а не новым
 */

class Animal {
    public void makeSound() {
        System.out.println("A sound");
    }
}

class Cat extends Animal {
    // @Override
    public void makeSoud() {  // опечатка
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.makeSound();
    }
}
