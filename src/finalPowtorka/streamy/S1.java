package finalPowtorka.streamy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class S1 {
    static void main() {
        // napisz kod ktory z podanej listy integerow znajduje liczbe ktora jest 2 pod wzgledem ilosci wystapien na liscie
// np input : 5, 5, 5, 4, 4, 2, 1
// result: 4
// co jesli pojawia sie dwie liczby o takiej samej ilosci wystapien? jak bys to obsłużył?

        List<Integer> list = new ArrayList<>(List.of(5, 5, 5, 4, 4, 2, 1));
        System.out.println(method(list,1));
        
    }
    public static Integer method(List<Integer> list, int skip){
        return Optional.ofNullable(list).orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer,Long> comparingByValue().reversed())
                .distinct()
                .skip(skip)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow();
    }
}
