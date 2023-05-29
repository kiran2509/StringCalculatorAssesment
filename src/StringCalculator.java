import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static int add(String numbers) throws NegativeNumberException {

        if(numbers.isEmpty())
            return 0;

        if(numbers.length() >1 && numbers.charAt(0) == '-' && Character.isDigit(numbers.charAt(1)))
            throw new NegativeNumberException(numbers +" Negatives not allowed");          // Handle with negative number if passed as argument

        String delimiter = ",";
        if(numbers.length() >2 && numbers.substring(0,2).equals("//"))
            delimiter = String.valueOf(numbers.charAt(2));


        String[] str = numbers.split(delimiter);
        int sum = 0;
        List<String> negativeNumbers = new ArrayList<>();

        for(int i=0;i<str.length;i++){

            if(str[i].equals("//"))
                continue;

            boolean flag = false;
            for(int j=0;j<str[i].length();j++){

                if(str[i].charAt(j) == '-'){
                    int k = j;
                    while(j+1<str[i].length() && Character.isDigit(str[i].charAt(j+1)))
                        j++;
                    negativeNumbers.add(str[i].substring(k,j+1));
                    flag = true;
                }
                else if(Character.isDigit(str[i].charAt(j))) {
                    int k = j;
                    while (j < str[i].length() && Character.isDigit(str[i].charAt(j)))
                        j++;
                    sum += Integer.parseInt(str[i].substring(k, j));
                    flag = true;
                }
            }
            if(!flag){
                System.out.println("Input is not a valid");
                return 0;
            }
        }
        if(negativeNumbers.size() > 0){                         // Handle multiple negative integers
            String s = String.join(",",negativeNumbers);
            s += " all are negative numbers";
            throw new NegativeNumberException(s);
        }

        return sum;
    }
}
