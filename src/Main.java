import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws NegativeNumberException {


//        Scanner st = new Scanner(System.in);
//        String s = st.next();

        // Below test cases are performed to validate the string with different inputs.
        System.out.println(StringCalculator.add(""));
        System.out.println(StringCalculator.add("1,2"));
        System.out.println(StringCalculator.add("1\n2,3"));
        System.out.println(StringCalculator.add("1,\n"));
        System.out.println(StringCalculator.add("//;1\n2;3;9"));
        System.out.println(StringCalculator.add("//-\n12-4-18"));
        System.out.println(StringCalculator.add("1,4,2,6,5,7,8,9,1,12,90,34,12"));
        System.out.println(StringCalculator.add("-1000"));
        System.out.println(StringCalculator.add("1,-19,12,-13,8"));
    }
}