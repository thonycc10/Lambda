import Interface.FunctionalGenerics;

public class LambdaFunctionals {
    public static void main(String[] args) {
        FunctionalGenerics<String, String> fun = s -> s.substring(1, 5);
        System.out.println(fun.execute("Hola Mundo"));

        FunctionalGenerics<String, Integer> fun1 = String::length;
        System.out.println(fun.execute("Hola Mundo"));
    }
}
