package finalPowtorka.neww;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    static void main() {
        /*
        Napisz metodę public static List<String> topKWords(String text, int k). Ma zwracać k najczęściej występujących słów w tekście:

wielkość liter nie ma znaczenia, wynik zwracaj małymi literami,
słowo to ciąg liter (np. "kot," to słowo "kot"),
przy równej liczbie wystąpień słowa idą alfabetycznie,
jeśli różnych słów jest mniej niż k, zwróć wszystkie,
text == null albo k < 0 → IllegalArgumentException.
         */
        System.out.println(topKWords("hej jestem hej jeden dwa jeden hej trzy dwa jeden hej ą ą ą ą ą ą ą ą a",3));
    }
    public static List<String> topKWords(String text, int k){
        if(text == null || k<0){
            throw new IllegalArgumentException();
        }

        return Arrays.stream(text.split("\\P{L}+"))
                .filter(s -> !s.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }
}
