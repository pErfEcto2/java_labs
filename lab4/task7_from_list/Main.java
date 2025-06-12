package lab4.task7_from_list;

import lab4.task3FromList.Person;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static String toString(Object obj) {
        if (obj == null) {
            return "";
        }
        Set<Object> visitedObjects = Collections.newSetFromMap(new IdentityHashMap<>());
        return toString(obj, visitedObjects);
    }

    private static String toString(Object obj, Set<Object> visitedObjects) {
        if (obj == null) {
            return "null";
        }

        if (visitedObjects.contains(obj)) {
            return "[...]";
        }

        visitedObjects.add(obj);

        Class<?> objClass = obj.getClass();

        if (isSimpleType(obj)) {
            return obj.toString();
        }

        if (objClass.isArray()) {
            StringBuilder result = new StringBuilder();
            result.append("[");
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                if (i > 0) result.append(", ");
                Object element = Array.get(obj, i);
                result.append(toString(element, visitedObjects));
            }
            result.append("]");
            return result.toString();
        }

        // is toString overridden?
        try {
            if (objClass.getMethod("toString").getDeclaringClass() != Object.class) {
                return obj.toString();
            }
        } catch (NoSuchMethodException e) {
        }

        StringBuilder result = new StringBuilder();
        result.append(objClass.getSimpleName()).append("{");

        Field[] fields = objClass.getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            if (!first) {
                result.append(", ");
            } else {
                first = false;
            }

            field.setAccessible(true);
            try {
                Object fieldValue = field.get(obj);
                result.append(field.getName()).append("=")
                        .append(toString(fieldValue, visitedObjects));
            } catch (IllegalAccessException e) {
                result.append(field.getName()).append("=<inaccessible>");
            }
        }

        result.append("}");
        return result.toString();
    }

    private static boolean isSimpleType(Object obj) {
        return obj instanceof Number || obj instanceof Character ||
                obj instanceof Boolean || obj instanceof String;
    }

    public static void main(String[] args) {
        Class<Person> personClass = Person.class;

        Field[] allPersonFields = personClass.getDeclaredFields();
        Field[] publicPersonFields = personClass.getFields();

        // to get all fields from parent classes also check task10
        System.out.println("All fields of Person class:");
        for (Field field : allPersonFields) {
            System.out.println("Field name: " + field.getName());
            System.out.println("Field type: " + field.getType());
            System.out.println("Field modifier: " + Modifier.toString(field.getModifiers()));
            System.out.println("---");
        }

        System.out.println("\nPublic fields of Person class:");
        for (Field field : publicPersonFields) {
            System.out.println("Field name: " + field.getName());
            System.out.println("Field type: " + field.getType());
            System.out.println("Field modifier: " + Modifier.toString(field.getModifiers()));
            System.out.println("---");
        }

        System.out.println("\ntoString objects:");
        Person person = new Person("Perfecto", 21);
        System.out.println("Person: " + toString(person));
        System.out.println("Person array: " + toString(new Person[]{person, new Person("Perfecto", 21)}));
        System.out.println("Fields array: " + toString(allPersonFields));
    }
}