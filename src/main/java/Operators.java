import java.util.Optional;
import java.util.stream.Stream;

public class Operators {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Valuef");
//        Optional<String> optional = Optional.empty();

        //map
        String orElse = optional.map(val -> "Replaced").orElse("Empty");
        System.out.println(orElse);

        //filter()
        Optional<String> filter = optional.filter(val -> val.equalsIgnoreCase("Value"));
        System.out.println(filter.orElse("Empty"));

        //flatMap
        Optional<String> flatMap = optional.flatMap(val -> Optional.of("Replaced by flatmap"));
        System.out.println(flatMap.get());

        //ifPresent
        Optional<String> optionalIfPresent = Optional.of("Value");
        optionalIfPresent.ifPresent(val -> System.out.println("This is a " + val));

        //ifPresentOrElse
        Optional.empty().ifPresentOrElse(System.out::println, () -> System.out.println("Value is absent"));

        //Stream
        Stream<String> stream = optionalIfPresent.stream();
        Optional.empty().stream().forEach(System.out::println);

        //or
        optionalIfPresent.or(() -> Optional.of("New Value")).ifPresent(System.out::println);
        Optional.empty().or(() -> Optional.of("New Value")).ifPresent(System.out::println);
        // Optional.empty().or(() -> null).ifPresent(System.out::println);

        //equals

        //optional
        //either both are empty
        //or if the values in optionals are equeals to each other via equeals method

        System.out.println(optionalIfPresent.equals(Optional.of("Value")));

        //hashcode
        System.out.println(optionalIfPresent.hashCode());

    }
}
