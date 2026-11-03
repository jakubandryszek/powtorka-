package zadanka;

import java.util.ArrayList;
import java.util.List;

public class IsSorted {
    static void main() {
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 8, 9, 10, 11));
        List<Integer> integers2 = new ArrayList<>(List.of(1, 1, 2, 3, 3, 4, 5, 6, 8, 9, 10, 11, 11));
        List<Integer> integers3 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 8, 9, 7, 10, 11));
        List<Integer> integers4 = new ArrayList<>(List.of(10, 8, 6, 4, 2, 0));
        List<Integer> integers5 = new ArrayList<>(List.of(10,10,10,10, 8, 6, 4, 2, 0,0));

        System.out.println(isSorted(integers));
        System.out.println(isSorted(integers2));
        System.out.println(isSorted(integers3));
        System.out.println(isSorted(integers4));
        System.out.println(isSorted(integers5));
    }

    public static boolean isSorted(List<Integer> integers) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < integers.size() - 1; i++) {
            if(integers.get(i+1)<integers.get(i)){
                increasing = false;
            }
            if(integers.get(i+1)> integers.get(i)){
                decreasing = false;
            }
        }
        return increasing||decreasing;
    }
}
