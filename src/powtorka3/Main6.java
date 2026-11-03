package powtorka3;

import java.util.*;

public class Main6 {
    static void main() {
         /*
        Napisz metodę, która przyjmuje dwa String-i i zwraca true,
        jeśli są swoimi anagramami — czyli składają się z dokładnie tych samych liter,
        w tej samej liczbie, tylko w innej kolejności.
         */

        System.out.println(method("",""));
        System.out.println(method("abcdabcd","dcbadcba"));
        System.out.println(method("abcd","aabcd"));
        System.out.println(method("aaaaa","aaa"));
        System.out.println(method("abccc","aaabc"));
    }
    public static boolean method(String s1 , String s2){
        if(s1==null||s2==null){
            throw new NullPointerException();
        }
        if(s1.length()!=s2.length()){
            return false;
        }

        List<String> list = new ArrayList<>(List.of(s1.split("")));
        list.sort(String::compareTo);
        List<String> list2 = new ArrayList<>(List.of(s2.split("")));
        list2.sort(String::compareTo);

        return list2.equals(list);
    }
}
