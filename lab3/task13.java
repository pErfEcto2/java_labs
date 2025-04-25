package lab3;

public class task13 {
    public static Runnable combine(Runnable[] tasks) {
        return () -> {
            for (Runnable task : tasks)
                task.run();
        };
    }

    public static void main(String[] args) {
        Runnable t1 = () -> System.out.println("task 1");
        Runnable t2 = () -> System.out.println("task 2");
        Runnable t3 = () -> System.out.println("task 3");

        Runnable combinedTask = combine(new Runnable[]{t1, t2, t3});

        combinedTask.run();
    }
}
