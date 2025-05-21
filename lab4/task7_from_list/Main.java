package lab4.task7_from_list;

import lab4.task3FromList.Person;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class Main {
    public static String toString(Object obj) {
        if (obj == null) {
            return "";
        }
        Set<Object> visitedObjects = Collections.newSetFromMap(new IdentityHashMap<>());
        return toString(obj, visitedObjects);
    }

    private static String toString(Object obj, Set<Object> visitedObjects) {
        if (visitedObjects.contains(obj)) {
            return "[...]";
        }

        visitedObjects.add(obj);

        Class<?> objClass = obj.getClass();
        StringBuilder result = new StringBuilder();

        if (objClass.isArray()) {
            result.append("[");
            int arrayLength = Array.getLength(obj);
            for (int i = 0; i < arrayLength; i++) {
                if (i > 0) result.append(", ");
                Object arrayElement = Array.get(obj, i);
                if (arrayElement == null) {
                    result.append("null");
                } else if (isSimpleType(arrayElement)) {
                    result.append(arrayElement);
                } else {
                    result.append(toString(arrayElement, visitedObjects));
                }
            }
            result.append("]");
        } else {
            if (objClass.getName().startsWith("java.")) {
                result.append(objClass.getSimpleName())
                        .append("@")
                        .append(Integer.toHexString(obj.hashCode()));
            } else {
                result.append(objClass.getSimpleName()).append("{");

                Field[] objectFields = objClass.getDeclaredFields();
                boolean isFirstField = true;

                for (Field field : objectFields) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) ||
                            java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                        continue;
                    }

                    if (!isFirstField) result.append(", ");
                    isFirstField = false;

                    String fieldName = field.getName();

                    try {
                        field.setAccessible(true);
                        Object fieldValue = field.get(obj);

                        if (fieldValue == null) {
                            result.append(fieldName).append("=null");
                        } else if (isSimpleType(fieldValue)) {
                            result.append(fieldName).append("=").append(fieldValue);
                        } else {
                            result.append(fieldName).append("=")
                                    .append(toString(fieldValue, visitedObjects));
                        }
                    } catch (IllegalAccessException e) {
                        result.append(fieldName).append("=<inaccessible>");
                    }
                }

                result.append("}");
            }
        }

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
        System.out.println("Fields array: " + toString(allPersonFields));
    }
}