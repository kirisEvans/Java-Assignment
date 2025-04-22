package assignment1;

import java.util.Scanner;

public class assignment13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num_min = input.nextInt();
        int num_max = input.nextInt();
        int i;
        boolean perfect = false;

        if (num_max<=2){
            i = -1;
        }
        else {
            for (i = num_min; i <= num_max; i++){
                int my_sum = 0;
                for (int j = 1; j <= i/2; j++){
                    if (i % j ==0){
                        my_sum += j;
                    }
                }
                if (my_sum == i){
                    perfect = true;
                    break;
                }
            }
        }
        if (perfect){
            System.out.println(i);
        }
        else {
            System.out.println(-1);
        }

    }
}
