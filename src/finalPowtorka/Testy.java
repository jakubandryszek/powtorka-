package finalPowtorka;

import java.util.Arrays;

public class Testy {
    static void main() {
        String s = "aibd";
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        System.out.println(sb);

        int[] array = new int[1];
        array[0] = 34;

        System.out.println(Arrays.toString(array));

        sb.append((char) 98);
        System.out.println(String.valueOf((char) 98));
        int x;
        System.out.println(Integer.valueOf(String.valueOf(sb)));
        System.out.println(2147483649L);
    }
}
