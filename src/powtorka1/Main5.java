package powtorka1;

public class Main5 {
    static void main() {
        /*
        Napisz metodę, która przyjmuje String i zwraca jego "skompresowaną" wersję,
        gdzie ciągi powtarzających się znaków są zastępowane znakiem + liczbą powtórzeń.
         */
        System.out.println(method("Heelllllooooooouuuuu"));
        System.out.println(method("hi"));
        System.out.println(method("hihihh"));

    }
    public static String method(String s){
        if(s == null){
            throw new IllegalArgumentException();
        }
        String returnString = "";
        String[] chars = s.split("");
        for(int i =0; i< chars.length; i++){
            int quantity = 1;
            for(int j = i+1; j<chars.length;j++){
                if(chars[i].equals(chars[j])){
                    quantity++;
                    i++;
                }else{
                    break;
                }
            }
            returnString += chars[i]+quantity;
        }
        return returnString;
    }
}
