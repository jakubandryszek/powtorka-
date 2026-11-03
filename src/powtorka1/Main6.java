package powtorka1;

import java.util.HashMap;
import java.util.Map;

public class Main6 {
    static void main() {
        /*
        Napisz metodę, która przyjmuje dwa String-i i zwraca true,
        jeśli są swoimi anagramami — czyli składają się z dokładnie tych samych liter, w tej samej liczbie, tylko w innej kolejności.
         */

        System.out.println(method("ala", "alla"));
        System.out.println(method("aa", "a"));
        System.out.println(method("", ""));
        System.out.println(method("aab", "abb"));

    }
    public static boolean method(String a, String b){
        if(a==null||b==null){
            throw new IllegalArgumentException();
        }
        if(a.length()!=b.length()){
            return false;
        }
        Map<String, Long> map1 = new HashMap<>();
        for(String s : a.split("")){
            map1.merge(s,1L,Long::sum);
        }
        Map<String,Long> map2 = new HashMap<>();
        for(String s: b.split("")){
            map2.merge(s,1L,Long::sum);
        }
        return map1.equals(map2);
    }
}
