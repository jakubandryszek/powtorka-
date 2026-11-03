package powtorka1;

import java.util.Arrays;
import java.util.Comparator;

public class Main2 {
    static void main() {
        /*
        Napisz metodę, która przyjmuje int[] i zwraca drugą największą unikalną wartość w tablicy.
         */

        int[] arr1 = {5, 1, 5, 3, 2};
        int[] arr2 = {10, 10, 9};
        int[] arr3 = {4, 4, 4};

        System.out.println(method(arr1));
        System.out.println(method(arr2));
        System.out.println(method(arr3));

    }
    public static Integer method(int[] array){
        return Arrays.stream(array)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
    }
}
