package assignment1;

import java.util.Scanner;

public class assignment14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char c1 = input.next().charAt(0);
        double temp1 = input.nextDouble();
        int n = input.nextInt();
        double[] my_list = new double[n];
        int min_index = 0;

        if (c1 == 'K'){
            temp1 = (int) (temp1 - 273.15);
        }
        else if (c1 == 'F'){
            temp1 = (temp1 - 32) * 5 / 9;
        }

        for (int i = 0; i < n; i++){
            char c = input.next().charAt(0);
            double temp = input.nextDouble();
            if (c == 'C'){
                my_list[i] = Math.abs(temp1 - temp);
            }
            else if (c == 'F'){
                temp = (temp - 32) * 5 / 9;
                my_list[i] = Math.abs(temp1 - temp);
            }
            else {
                temp = temp - 273.15;
                my_list[i] = Math.abs(temp1 - temp);
            }
        }

        for (int i = 0; i < my_list.length; i++) {
            if (my_list[i] < my_list[min_index]) {
                min_index = i;
            }
        }
        System.out.println(min_index+1);
    }
}
