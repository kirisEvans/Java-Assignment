package assignment1;

import java.util.Scanner;

public class assignment11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] my_list = new int[n];
        for (int i = 0; i<n; i++) {
            int my_case = input.nextInt();
            my_list[i] = my_case%10;
        }
        input.close();
        for (int i = 0; i < n; i++) {
            System.out.println(my_list[i]);
        }

    }
}
