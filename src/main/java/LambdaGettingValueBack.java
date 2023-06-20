import java.util.Optional;

public class LambdaGettingValueBack {
    public static void main(String[] args) {
        Integer a = 10;
        Optional<Integer> optional = Optional.of(a);

        // get
        Integer integerVal = optional.get();
        System.out.println(integerVal);
        Optional<Integer> emptyOriginal = Optional.empty();
//        emptyOriginal.get(); retorna un error por que es vacio emptu

        //isPresent
        Integer val = emptyOriginal.isPresent() ? emptyOriginal.get() : 0;
        System.out.println(val);

        // orElse, orElseGet

        //orElse
        Integer orElse = optional.orElse(0);
        System.out.println(orElse);

        //orElseGet
        Integer orElseGet = emptyOriginal.orElseGet(() -> 0);
        System.out.println(orElseGet);

        //orElseThrow
        Integer orElseThrow = emptyOriginal.orElseThrow(() -> new IllegalArgumentException());

        // orElseThrow() = get();
    }
}
