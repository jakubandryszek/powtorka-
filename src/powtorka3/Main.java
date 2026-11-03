package powtorka3;

import java.util.*;

public class Main {
    static void main() {
         /*
        Napisz metodę, która przyjmuje List<String> i zwraca pierwsze słowo,
        które występuje w liście dokładnie raz (nie powtarza się).
         */

        System.out.println(method(Arrays.asList("1","2","3")));
        System.out.println(method(Arrays.asList("1","2","1")));
        System.out.println(method(Arrays.asList("1","1","1")));
        System.out.println(method(Arrays.asList()));
    }
    public static String method(List<String> strings){
        for(String s: strings){
            List<String> actual = new ArrayList<>(List.copyOf(strings));
            actual.remove(s);
            if(!actual.remove(s)){
                return s;
            }
        }
        return null;
    }

}
