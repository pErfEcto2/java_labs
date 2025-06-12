package lab4.task3FromList;


import java.util.Objects;

public class Person {
    private String name;
    private int age;
    public int a;
    public int b;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.a = 1;
        this.b = 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);  // Генерирует хеш на основе полей
    }
}
