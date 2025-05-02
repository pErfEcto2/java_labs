package lab3;

public class task8_from_list {
    public static void printHello() {
        System.out.println("Thread 3 is running!");
    }

    public static void main(String[] args) {
        // anonymous class which implements Runnable functional interface
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 is running!");
            }
        }).start();

        // same with lambda expression
        new Thread(() -> System.out.println("Thread 2 is running!")).start();

        // same with static method
        new Thread(task8_from_list::printHello).start();
    }
}
