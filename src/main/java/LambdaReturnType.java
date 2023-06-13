import Interface.LenthOfString;

public class LambdaReturnType {

    public static void main(String[] args) {
        LenthOfString name = String::length;
        int length = name.length("Thony");
        System.out.println(length);

        LenthOfString len = str -> {
            int l = str.length();
            System.out.println("The length of the given String is: " + l);
            return l;
        };
        int number = len.length("Camile");
        System.out.println(number);

    }
}
