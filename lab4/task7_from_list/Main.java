package lab4.task7_from_list;


import lab4.task3FromList.Person;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        Class<Person> clazz = Person.class;

        Field[] allFields = clazz.getDeclaredFields();
        Field[] publicFields = clazz.getFields();

        for (Field field : allFields) {
            System.out.println("name: " + field.getName());
            System.out.println("type: " + field.getType());
            System.out.println("---");
        }

        System.out.println();

        for (Field field : publicFields) {
            System.out.println("name: " + field.getName());
            System.out.println("type: " + field.getType());
            System.out.println("---");
        }
    }
}
