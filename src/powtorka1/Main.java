package powtorka1;

import java.util.*;

public class Main {
    static void main() {
           /*
        napisz metode ktorą jako argument przyjmuje liste tablic intów a jako wynik zwraca tylko
         te tablice ktorych liczbe parzyste nigdy sie nie powtarzaja
         */

        int[] arr1 = {1,2,3,4};
        int[] arr2 = {2,3,2};
        int[] arr3 = {1,3,3,2};
        int[] arr4 = {};
        List<int[]> list = new ArrayList<>(List.of(arr1,arr2,arr3,arr4));
        for(int[] i: streamMethod(list)){
            System.out.println(Arrays.toString(i));
        }

    }
    public static List<int[]> method(List<int[]> list){
        if(list == null || list.isEmpty()){
            throw new IllegalArgumentException();
        }
        List<int[]> returnList = new ArrayList<>();
        for(int[] i : list){
            Set<Integer> set = new HashSet<>();
            boolean add = true;
            for(int j:i){
                if(j%2==0 && !set.add(j)){
                    add = false;
                    break;
                }
            }
            if(add){
                returnList.add(i);
            }
        }
        return returnList;
    }

    public static List<int[]> streamMethod(List<int[]> list){
        return list.stream()
                .filter(Main::arrayCheck)
                .toList();
    }
    public static boolean arrayCheck(int[] array){
        Set<Integer> set = new HashSet<>();
        for(int value : array){
            if(value%2==0&&!set.add(value)){
               return false;
            }
        }
        return true;
    }
}
