package powtorka3;

import java.util.*;

public class Main2 {
    static void main() {
         /*
        napisz metode ktorą jako argument przyjmuje liste tablic intów a jako wynik zwraca tylko
         te tablice ktorych liczbe parzyste nigdy sie nie powtarzaja
         */
        for(int[] ints : method(Arrays.asList(new int[] {1,1,2,3,2}, new int[] {5,2,3,4}, new int[] {2}))){
            for(int i = 0; i< ints.length ; i++){
                System.out.println(ints[i]);
            }
            System.out.println("next");
        }

    }
    public static List<int[]> method(List<int[]> list){
        List<int[]> returnList = new ArrayList<>();
        for(int[] ints : list){
            boolean add = true;
            Set<Integer> set = new HashSet<>();
            for(int i = 0 ; i< ints.length ; i++){
                if(ints[i]%2==0&&!set.add(ints[i])){
                    add=false;
                }
            }
            if(add){
                returnList.add(ints);
            }
        }
        return returnList;
    }
}
