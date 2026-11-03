package finalPowtorka.neww;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main(String[] args) {
        Map<String,Integer>map = new HashMap<>();
        map.put("a",1);
        Runnable runnable = ()-> map.putIfAbsent("2",2);
        runnable.run();

        System.out.println(map);

String s = "02";
if(String.valueOf(s.charAt(0)).isBlank()){
    System.out.println(true);
}
        System.out.println("test");
        System.out.println(s.charAt(0));
int x = s.charAt(0);
        System.out.println(x);
x+= s.charAt(1);
int z = Integer.MAX_VALUE;
        System.out.println(x);
        long iuashd = -91283472332L;
        if(iuashd<Integer.MIN_VALUE){
            System.out.println("mniejzs");
            System.out.println(Integer.MIN_VALUE);
        }
        System.out.println(Long.MAX_VALUE);
        String mmm = "0000";
        if(s.charAt(0)=='0'){

        }
        System.out.println(Integer.valueOf(mmm.charAt(0)));

    }


}
