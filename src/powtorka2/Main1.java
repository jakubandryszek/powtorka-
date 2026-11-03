package powtorka2;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main1 {
    static void main() {
        System.out.println(loneSum(2,3,3));




    }
    public static int loneSum(int a, int b, int c) {
        return Optional.of(List.of(a,b,c)).orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter((v)-> v.getValue()==1)
                .map(Map.Entry::getKey)
                .reduce(0,Integer::sum);





    }


}
