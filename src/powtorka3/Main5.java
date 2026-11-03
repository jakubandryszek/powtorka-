package powtorka3;

public class Main5 {
    static void main() {
        /*
        Napisz metodę, która przyjmuje String i zwraca jego "skompresowaną" wersję,
        gdzie ciągi powtarzających się znaków są zastępowane znakiem + liczbą powtórzeń.
         */

        System.out.println(method("hello"));
    }
    public static String method(String input){
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(int i = 0 ; i < input.length()-1 ; i++){
            counter++;
            if(input.charAt(i)!=input.charAt(i+1)){
                sb.append(String.valueOf(input.charAt(i))+counter);
                counter=0;
            }
        }
        if(input.charAt(input.length()-1)!=input.charAt(input.length()-2)){
            sb.append(String.valueOf(input.charAt(input.length()-1))+1);
        }
        return String.valueOf(sb);
    }
}
