import java.util.stream.IntStream;

public class LambdaUnderTheHood {

    public static void main (String[] args) {

        /*Interface.MyFunctionalInterface myFunctionalInterface2 = new Interface.MyFunctionalInterface() {
            @Override
            public void myMethod() {
                System.out.println("myFunctionalInterface2");
            }
        };

        Interface.MyFunctionalInterface myFunctionalInterface1 = new Interface.MyFunctionalInterface() {
            @Override
            public void myMethod() {
                System.out.println("myFunctionalInterface1");

            }
        };*/

//        Interface.MyFunctionalInterface m1 = () -> System.out.println("I am Light wieght");

        // Imperative
        int sumOfEvens = 0;
        /*for (int i = 0; i <= 100; i ++) {
            if(i % 2 == 0) {
                sumOfEvens = sumOfEvens + i;
            }
        }

        System.out.println(sumOfEvens);*/

        // Declarative or Functional

        sumOfEvens = IntStream.rangeClosed(0, 100)
                .filter(i -> i % 2 == 0)
                .reduce(Integer::sum)
                .getAsInt();

        System.out.println(sumOfEvens);
    }
}
