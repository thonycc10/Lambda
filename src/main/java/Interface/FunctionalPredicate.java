package Interface;

@FunctionalInterface
public interface FunctionalPredicate<T> {
    boolean test(T t);
}
