package testKacperPowtorka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Part1 {
    static void main() {


        //Stwórz plik z 5 liczbami, odczytaj go i policz ich sumę.
        List<Integer> readIntegers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/testKacperPowtorka/file.txt"))){
            String number = "";
            while ((number= br.readLine())!= null){
                readIntegers.add(Integer.valueOf(number));
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        // zapisz liczby z listy do nowego pliku
        try(FileWriter fw = new FileWriter("src/testKacperPowtorka/fileWrite.txt")){
            for(Integer i : readIntegers){
                fw.write(i+"\n");
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        //sortowanie rosnaco i malejaco
        System.out.println(readIntegers);
        readIntegers.sort(Integer::compareTo);
        System.out.println(readIntegers);
        readIntegers.sort(Comparator.comparing(Integer::intValue).reversed());
        System.out.println(readIntegers);

        /*
        // napisz kod ktory z podanej listy integerow znajduje liczbe ktora jest 2 pod wzgledem ilosci wystapien na liscie
// np input : 5, 5, 5, 4, 4, 2, 1
// result: 4
// co jesli pojawia sie dwie liczby o takiej samej ilosci wystapien? jak bys to obsłużył?
         */
        System.out.println(getSecondByRepeats(Arrays.asList(5, 5, 5, 4, 4, 2, 1)));

    }
    public static Integer getSecondByRepeats(List<Integer> numbers){
        return Optional.ofNullable(numbers).orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(integer -> integer , Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .skip(1)
                .findFirst()
                .orElseThrow();

    }
}
