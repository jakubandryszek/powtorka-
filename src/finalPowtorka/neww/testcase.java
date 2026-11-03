package finalPowtorka.neww;

public class testcase {
    static void main() {
        System.out.println(myAtoi("42"));
    }
        public static int myAtoi(String s) {
            if(s.length()==0){
                return 0;
            }
            boolean isNegative = false;
            int i = 0;
            while (i<s.length()) {
                if (String.valueOf(s.charAt(i)).matches("\\d")) {
                    break;
                }
                if (String.valueOf(s.charAt(i)).isBlank()) {
                    i++;
                } else if (String.valueOf(s.charAt(i)).equals("-")) {
                    isNegative = true;
                    i++;
                    break;
                }else if(String.valueOf(s.charAt(i)).equals("+")){
                    isNegative = false;
                    i++;
                    break;
                }else {
                    return 0;
                }
            }
            long returnInt = 0;
            for (int j = i; j < s.split("").length ; j++) {

                if(String.valueOf(s.charAt(j)).matches("\\d")){

                    long temp = returnInt;
                    returnInt = returnInt *10;
                    returnInt+= s.charAt(j)-48;

                    if(isNegative &&  temp >  returnInt){
                        return Integer.MIN_VALUE;
                    }else if(!isNegative && temp > returnInt){
                        return Integer.MAX_VALUE;
                    }
                }else{
                    break;
                }
            }
            if(isNegative){
                returnInt = returnInt * (-1);
            }
            if(!isNegative && returnInt>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

            if(isNegative && returnInt<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            int returnInteger = 0;
            try{
                returnInteger = Math.toIntExact(returnInt);
            }catch(Exception e){
                if(isNegative){
                    return Integer.MIN_VALUE;
                }
                if(!isNegative){
                    return Integer.MAX_VALUE;
                }
            }
            return returnInteger;
        }
    }

