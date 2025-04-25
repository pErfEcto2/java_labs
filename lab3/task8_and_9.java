package lab3;


class Greeter implements Runnable {
    int n;
    String target;

    public Greeter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println("Hello " + target);
        }
    }
}

class task8 {
    public static void runTogether(Runnable... tasks) {
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }

    public static void main(String[] args) {
        Runnable task1 = new Greeter(3, "1");
        Runnable task2 = new Greeter(2, "2");

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (Exception _) {}

        try {
            t2.join();
        } catch (Exception _) {}


        System.out.println("\nRunning together: ");
        runTogether(task1, task2);

        try {
            Thread.sleep(500);
        } catch (Exception _) {}

        System.out.println("\nRunning in order: ");
        runInOrder(task1, task2);
    }
}