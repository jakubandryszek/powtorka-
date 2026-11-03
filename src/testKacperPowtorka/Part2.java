package testKacperPowtorka;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Part2 {
    static void main() {
        // napisz metode która generuje 100 liczb parzystych lub nieparzystych w zaleznosci od parametru
        System.out.println(generate100numbers(5));

        System.out.println(method1("pass"));
        System.out.println(method2("pass"));


    }
    public static List<Integer> generate100numbers(int parameter){
        return IntStream.iterate(parameter, x-> x+2)
                .limit(100)
                .boxed()
                .toList();
    }

        public static boolean method1(String password) {
        if (password == null) {
            return false;
        } else {
            return password.equals("PASS");
        }
    }
    public static boolean method2(String password){
        return Optional.ofNullable(password)
                .filter(p-> p.equals("PASS"))
                .isPresent();

    }


        public static void method3(List<String> list, String password) {
        if (password != null) {
            list.add(password);
        }
    }

    public static void method4(List<String> list,  String password){
        Optional.ofNullable(password)
                .ifPresent(list::add);
    }
}
