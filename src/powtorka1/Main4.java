package powtorka1;

import java.util.*;

public class Main4 {
    static void main() {
        /*
        Napisz metodę, która przyjmuje List<String> i zwraca pierwsze słowo, które występuje w liście dokładnie raz (nie powtarza się).
         */
        List<String> strings = new ArrayList<>(List.of("a", "b", "b", "a"));
        List<String> strings2 = new ArrayList<>(List.of("a", "a", "b"));
        List<String> strings3 = new ArrayList<>(List.of("a", "b"));
        List<String> strings4 = new ArrayList<>(List.of());

        System.out.println(methodOn(strings));
        System.out.println(methodOn(strings2));
        System.out.println(methodOn(strings3));
        System.out.println(methodOn(strings4));

    }
    public static String method(List<String> strings){
        for(int i =0; i<strings.size(); i++){
            if(!strings.subList(0,i).contains(strings.get(i))&&!strings.subList(i+1,strings.size()).contains(strings.get(i))){
                return strings.get(i);
            }
        }
        return null;
    }

    public static String methodOn(List<String> strings){
        if(strings==null){
            throw new IllegalArgumentException();
        }
        Map<String, Long> map = new LinkedHashMap<>();
        for(String s:strings){
            map.merge(s,1L,Long::sum);
        }
        for(Map.Entry<String,Long> entry : map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return null;
    }
}
