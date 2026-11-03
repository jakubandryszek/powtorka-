package powtorka3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main8 {
    static void main() {
        // napisz metode która generuje 100 liczb parzystych lub nieparzystych w zaleznosci od parametru
        System.out.println(method(100, false));
    }
    public static List<Integer> method(int quantity, boolean even){
        int seed = even?0:1;
        return IntStream.iterate(seed, i-> i+2)
                .boxed()
                .limit(quantity)
                .collect(Collectors.toList());
    }
}
