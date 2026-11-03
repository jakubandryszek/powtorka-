package powtorka3;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main4 {
    static void main() {
        /*
        Napisz metodę, która przyjmuje String i zwraca Map<Character, Integer>
        — mapę zliczającą, ile razy każdy znak występuje w tekście.
         */
        System.out.println(method("Jakub"));
        System.out.println(method("aaabbc"));
        System.out.println(method("a"));

    }
    public static Map<Character, Long> method(String s){

        if(s==null|| s.isEmpty()){
            throw new IllegalArgumentException();
        }
        return Arrays.stream(s.split(""))
                .map(ch-> ch.charAt(0))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
