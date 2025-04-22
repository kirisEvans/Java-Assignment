package assignment2;

import java.util.Scanner;

public class assignment22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] cats = new int[n];
        int[] dogs = new int[n];

        for (int i = 0; i < n; i++){
            cats[i] = input.nextInt();
        }

        for (int i = 0; i < n; i++){
            dogs[i] = input.nextInt();
        }

        for (int j = 0; j < n; j++){
            if (cats[j] == -1){

                if (j == 0){
                    if (cats[j+1] != -1){
                        cats[j] = (int) (cats[j+1] * 0.8);
                    }
                }

                else if (j == n-1){
                    if (cats[j-1] != -1){
                        cats[j] = (int) (cats[j-1] * 0.8);
                    }
                }

                else {
                    if (cats[j-1] != -1 & cats[j+1] != -1){
                        cats[j] = (int) (cats[j-1] * 0.4 + cats[j+1] * 0.6);
                    }
                }
            }
        }

        for (int j = 0; j < n; j++){
            if (dogs[j] == -1){

                if (j == 0){
                    if (dogs[j+1] != -1){
                        dogs[j] = (int) (dogs[j+1] * 0.8);
                    }
                }

                else if (j == n-1){
                    if (dogs[j-1] != -1){
                        dogs[j] = (int) (dogs[j-1] * 0.8);
                    }
                }

                else {
                    if (dogs[j-1] != -1 & dogs[j+1] != -1){
                        dogs[j] = (int) (dogs[j-1] * 0.4 + dogs[j+1] * 0.6);
                    }
                }
            }
        }

        int  m = input.nextInt();
        if (cats[m-1] == -1 & dogs[m-1] == -1){
            System.out.println("ALL DATA LOST");
        }

        else if (cats[m-1] == -1){
            System.out.println("CAT DATA LOST");
        }

        else if (dogs[m-1] == -1){
            System.out.println("DOG DATA LOST");
        }

        else {
            System.out.println(cats[m-1] + dogs[m-1]);
        }
    }
}