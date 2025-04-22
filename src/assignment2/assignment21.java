package assignment2;

import java.util.Scanner;

public class assignment21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] cats = new int[n];
        int[] dogs = new int[n];
        int[] miss = new int[n];

        for (int i = 0; i < n; i++){
            cats[i] = input.nextInt();
            if (cats[i] == -1){
                miss[i] += 1;
            }
        }

        for (int i = 0; i < n; i++){
            dogs[i] = input.nextInt();
            if (dogs[i] == -1){
                miss[i] += 1;
            }
        }

        int  m = input.nextInt();
        System.out.println(miss[m-1]);
    }
}
