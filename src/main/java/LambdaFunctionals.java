import Interface.FunctionalGenerics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class LambdaFunctionals {
    public static void main(String[] args) {
//        Function
        FunctionalGenerics<String, String> fun = s -> s.substring(1, 5);
        System.out.println(fun.execute("Hola Mundo"));

        FunctionalGenerics<String, Integer> fun1 = String::length;
        System.out.println(fun1.execute("Hola Mundo"));

//        Predicate
        List<String> list = new ArrayList<>();
        list.add("Basic");
        list.add("");
        list.add("Strong");
        list.add("");
        list.add("BasicStrong");

        Predicate<String> predicate = s -> !s.isEmpty();
        List<String> newList = filterList(list, predicate);

        Predicate<String> filter = s -> s.contains("Basic");
        List<String> filteredList = filterList(list, filter);

        System.out.println(newList);
        System.out.println(filteredList);

        List<Integer> intList = List.of(1,4,5,6,7,8);
        Predicate<Integer> integerFilter = e -> e % 2 == 0;
        List<Integer> newListInteger = filterList(intList, integerFilter);
        System.out.println(newListInteger);

        // Consumer
        List<Integer> listNum = List.of(23,5,3,24,62,43,62,89);
        Consumer<Integer> consumerInt = System.out::println;
        consumerInt.accept(55);

        printElements(listNum, consumerInt);

        // Supplier
        Supplier<String> stringSupplier = () -> new String("A String");
        System.out.println(stringSupplier.get());

        Supplier<Double> mathNumber = () -> Math.random();
        System.out.println(mathNumber.get());

        // function
        List<String> listFunction = List.of("Kit", "Kot", "Shake");
        Function<String, Integer> function = String::length;
        List<Integer> newListFunction = map(listFunction, function);
        System.out.println(newListFunction);

        // UnaryOperator
        List<Integer> listUO = List.of(10,20,30,40,50);
        UnaryOperator<Integer> operator = e -> e * 100;
        List<Integer> newListUO = mapper(listUO, operator);
        System.out.println(newListUO);
    }

    private static <T> List<T> mapper(List<T> listUO, UnaryOperator<T> operator) {
        List<T> newList = new ArrayList<>();
        for (T e : listUO) {
            newList.add(operator.apply(e));
        }
        return newList;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<>();
        for(T e: list) {
            newList.add(function.apply(e));
        }
        return newList;
    }

    private static <T> void printElements(List<T> list, Consumer<T> consumerInt) {
        for (T t: list) {
            consumerInt.accept(t);
        }
    }

    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T row: list) {
            if (predicate.test(row)) {
                newList.add(row);
            }
        }
        return newList;
    }
}
