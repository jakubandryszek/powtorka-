package readandwrite.raw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReadAndWrite {
    static void main() {
        /*
        Napisz program, który wczytuje z pliku tekstowego listę słów
        (każde słowo znajduje się w osobnej linii).
        Następnie usuń wszystkie duplikaty i zapisz unikalne słowa do nowego pliku,
        posortowane alfabetycznie w odwrotnej kolejności (od Z do A).
         */
        List<String> readWords = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/readandwrite/words.txt"))){
            String line;
            while ((line= br.readLine())!=null){
                readWords.add(line);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        writeToFile("src/readandwrite/wordsRepaired", repairList(readWords));
    }
    public static List<String> repairList(List<String> strings){
        return Optional.ofNullable(strings).orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
    }
    public static void writeToFile(String fileName, List<String> strings){
        try(FileWriter fw = new FileWriter(fileName)){
            for(String s: strings){
                fw.write(s+"\n");
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
