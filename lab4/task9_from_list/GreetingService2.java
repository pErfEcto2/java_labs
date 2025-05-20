package lab4.task9_from_list;

public class GreetingService2 implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello (2), " + name + "!";
    }
}
