package assignment3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class assignment31 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String rune = input.nextLine();
        ArrayList<String> my_list = new ArrayList<>();
        String regex = "[a-zA-Z]+|\\d+";
        int sum = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rune);

        while (matcher.find()){
            my_list.add(matcher.group());
        }
        for (String s : my_list) {
            sum += to_num(s);
        }
        System.out.println(sum);
    }

    public static int to_num(String my_rune) {
        if (my_rune.length() == 1){
            return 0;
        }

        String reverse = new StringBuilder(my_rune).reverse().toString();
        if (my_rune.length() % 2 == 0) {  //为偶数
            if (Character.isDigit(reverse.charAt(0))) {
                return Integer.parseInt(reverse);
            } else {
                int sum = 0;
                for (char c : reverse.toCharArray()) {
                    sum += c;
                }
                return sum;
            }
        } else {
            int mid_index = reverse.length() / 2;
            String result = reverse.substring(0, mid_index) + reverse.substring(mid_index + 1);
            if (Character.isDigit(result.charAt(0))) {
                return Integer.parseInt(result);
            } else {
                int sum = 0;
                for (char c : result.toCharArray()) {
                    sum += c;
                }
                return sum;
            }
        }
    }
}
