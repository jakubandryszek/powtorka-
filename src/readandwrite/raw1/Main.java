package readandwrite.raw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static void main() throws IOException {
        //zapisz do pliku 5 liczb
        try(FileWriter fw = new FileWriter("src/readandwrite/numbers.txt")){
            Random random = new Random();
            for(int i =0; i<5; i++){
                fw.write((random.nextInt(10))+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //odczytaj z pliku do listy:
        List<Integer> integers = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/readandwrite/numbers.txt"))){
            String line;
            while((line = br.readLine())!= null){
                integers.add(Integer.valueOf(line));
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        //sortowanie i odwrotne sortowanie
        System.out.println(integers);
        integers.sort(Integer::compare);
        System.out.println(integers);
        integers.sort(Comparator.comparing(Integer::intValue).reversed());
        System.out.println(integers);

        //wybierz liczbe drugą co do powtorzen:
        List<Integer> test = new ArrayList<>(List.of(1,1,1,2,2,2,2,3,3,3,4,4));

        System.out.println(getSecondMostRepeated(test));
    }
    public static int getSecondMostRepeated(List<Integer> integers){
        return Optional.ofNullable(integers).orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.groupingBy(a-> a, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }

}
