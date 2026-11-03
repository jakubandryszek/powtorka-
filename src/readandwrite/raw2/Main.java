package readandwrite.raw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        //zapisz do pliku 5 randomowych liczb

        try(FileWriter fw = new FileWriter("src/readandwrite/raw2/nums.txt")){
            Random random = new Random();
            for (int i = 0 ; i< 5; i++){
                fw.write(random.nextInt(10)+"\n");
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        //odczytaj z pliku do listy
        List<Integer> numbers = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/readandwrite/raw2/nums.txt"))){
            String line;
            while ((line=br.readLine())!=null){
                numbers.add(Integer.valueOf(line));
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println(numbers);


        List<Integer> numbers2 = new ArrayList<>(List.of(5, 5, 5, 4, 4,4, 3, 3, 2, 1));


        //zwroc liste liczb ktore sa drugie pod wzgledem wystapien
        System.out.println("wystapienia");
        System.out.println(findSecondOne(numbers2));

    }

    public static List<Integer> findSecondOne(List<Integer> numbers){
        return Optional.ofNullable(numbers).orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .skip(1)
                .findFirst().map(Map.Entry::getValue).orElseThrow();

    }
}
