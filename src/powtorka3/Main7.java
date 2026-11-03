package powtorka3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main7 {
    static void main() {
        /*
        // napisz kod ktory z podanej listy integerow znajduje liczbe ktora jest 2 pod wzgledem ilosci wystapien na liscie
// np input : 5, 5, 5, 4, 4, 2, 1
// result: 4
// co jesli pojawia sie dwie liczby o takiej samej ilosci wystapien? jak bys to obsłużył?
         */
        System.out.println(method(Arrays.asList(1,2,3,4,3,4,3,4,3,3,5,4,8,8,3)));
        System.out.println(method(Arrays.asList(5, 5, 5, 4, 4, 2, 1)));
    }
    public static int method(List<Integer> list){
        return Optional.ofNullable(list).orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
                .skip(1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow();
    }
}
