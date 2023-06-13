import Interface.FunctionalGenerics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    }

    private static List<String> filterList(List<String> list, Predicate<String> predicate) {
        List<String> newList = new ArrayList<>();
        for (String string: list) {
            if (predicate.test(string)) {
                newList.add(string);
            }
        }
        return newList;
    }
}
