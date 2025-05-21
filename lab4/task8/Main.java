package lab4.task8;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String [] args) {
        System.out.println("---full class name---");
        System.out.println(double.class.getName());
        System.out.println(Double[].class.getName());
        System.out.println(List.class.getName());
        System.out.println(TestClass.InnerTestClass.class.getName());

        System.out.println("\n---class name without package---");
        System.out.println(double.class.getSimpleName());
        System.out.println(Double[].class.getSimpleName());
        System.out.println(List.class.getSimpleName());
        System.out.println(TestClass.InnerTestClass.class.getSimpleName());

        System.out.println("\n---full name with package and inner classes---");
        System.out.println(double.class.getCanonicalName());
        System.out.println(Double[].class.getCanonicalName());
        System.out.println(List.class.getCanonicalName());
        System.out.println(TestClass.InnerTestClass.class.getCanonicalName());

        System.out.println("\n---type name---");
        System.out.println(double.class.getTypeName());
        System.out.println(Double[].class.getTypeName());
        System.out.println(new ArrayList<Integer>() {}.getClass().getTypeName());
        System.out.println(TestClass.InnerTestClass.class.getTypeName());

        System.out.println("\n---type declaration---");
        System.out.println(double.class.toGenericString());
        System.out.println(Double[].class.toGenericString());
        System.out.println(new ArrayList<Integer>() {}.getClass().toGenericString());
        System.out.println(TestClass.InnerTestClass.class.toGenericString());

        System.out.println("\n---'class'/'interface'/... <name>---");
        System.out.println(double.class.toString());
        System.out.println(Double[].class.toString());
        System.out.println(List.class.toString());
        System.out.println(TestClass.InnerTestClass.class.toString());
    }
}
