package lab4.task9_from_list;

public class GreetingService1 implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello (1), " + name + "!";
    }
}