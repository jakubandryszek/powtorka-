package powtorka3;

import java.util.Arrays;
import java.util.Comparator;

public class Main3 {
    static void main() {
        /*
        Napisz metodę, która przyjmuje int[] i zwraca drugą największą unikalną wartość w tablicy.
         */

        System.out.println(method(new int[] {1,2,6,8,8}));
        System.out.println(method(new int[] {}));
        System.out.println(method(new int[] {2,4,6,2,3,1,0,-2}));

    }
    public static Integer method(int[] ints){
        return Arrays.stream(ints)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }
}
