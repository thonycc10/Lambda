import Interface.IConfigurator;
import Interface.IFactory;
import Interface.IProducer;

public class HigherOrderFunctions {
    public static void main(String[] args) {
        IFactory<Integer> createFactory = createFactory(() -> Math.random()*100, Double::intValue);
        Integer product = createFactory.create();
        System.out.println(product);
    }

    public static <T,R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T,R> configurator) {
        return () -> {
            T product = producer.produce();
            return configurator.configure(product);
        };
    }
}
