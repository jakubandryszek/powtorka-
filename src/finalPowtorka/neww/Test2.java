package finalPowtorka.neww;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    static void main() {
//liczby pierwsze z przedzialu from to
        System.out.println(primesInRange(10,30));
        System.out.println(primesInRange(0,10));
        System.out.println(primesInRange(-5,1));
        System.out.println(primesInRange(17,17));
        System.out.println(primesInRange(20,10));
    }
    public static List<Integer> primesInRange(int from, int to){
        if(to<from){
            throw new IllegalArgumentException();
        }
        if(from<0){
            from = 0;
        }
        if(to<2){
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        for(int i = from ; i <= to ; i++){
            int counter = 0;
            for(int j = 1 ; j <= i/2 ; j++){
                if(i%j==0){
                    counter++;
                }
                if(counter>1){
                    break;
                }
            }
            if(counter==1){
                list.add(i);
            }
        }
        return list;
    }
}
