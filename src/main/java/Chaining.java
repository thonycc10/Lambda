import Interface.Consumer;

import java.util.function.Function;

public class Chaining {
    public static void main(String[] args) {
        Consumer<String> consumer1 = s -> System.out.println(s);
        Consumer<String> consumer2 = s -> System.out.println(s);

        consumer1.accept("Hello 1");
        consumer2.accept("Hello 2");

        Consumer<String> c3 = s ->
        {
            consumer1.accept(s);
            consumer2.accept(s);
        };

        c3.accept("Hello");

        Consumer<String> c4 = consumer1.thenAccept(consumer2);
        c4.accept("BasiscStrong");

        Function<Integer, Integer> f1 = s -> s+2;
        Function<Integer, Integer> f2 = s -> s*2;
        Function<Integer, Integer> f3 = f1.andThen(f2);

        System.out.println(f3.apply(10));
    }
}
