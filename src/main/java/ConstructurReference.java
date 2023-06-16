import java.util.function.Function;

public class ConstructurReference {
    public static void main(String[] args) {

        Function<Runnable, Thread> threadFunction = Thread::new;

        Runnable task1 = () -> System.out.println("Task1");
        Runnable task2 = () -> System.out.println("Task2");

        Thread thread1 = threadFunction.apply(task1);
        Thread thread2 = threadFunction.apply(task2);

        thread1.start();
        thread2.start();

        threadFunction
                .apply(() -> System.out.println("Task3"))
                .start();

    }
}
