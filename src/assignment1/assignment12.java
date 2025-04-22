package assignment1;

import java.util.Arrays;
import java.util.Scanner;

public class assignment12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int n3 = n % 10; //百分位
        int n2 = ((n-n3)/10) % 10;
        int n1 = (n-n3-n2*10)/100;
        int[] my_list = {n3, n2, n1};
        Arrays.sort(my_list);
        if (m==0){
            System.out.println(my_list[2]+""+my_list[1]+""+my_list[0]);
        }
        else {
            System.out.println(my_list[0]+""+my_list[1]+""+my_list[2]);
        }
    }
}
