package powtorka1;

import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
    static void main() {
        /*
        Napisz metodę, która przyjmuje String i zwraca Map<Character, Integer> — mapę zliczającą, ile razy każdy znak występuje w tekście.
         */
        System.out.println(method("hello"));
        System.out.println(method(null));
    }
    public static Map<Character, Long> method(String s){
        if(s==null){
            throw new IllegalArgumentException();
        }

    return s.chars()
            .mapToObj(c->(char)c)
            .collect(Collectors.groupingBy(c->c, Collectors.counting()));
    }
}
