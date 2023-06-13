package Interface;

@FunctionalInterface
public interface FunctionalGenerics<T, R> {
    R execute(T t);
}
