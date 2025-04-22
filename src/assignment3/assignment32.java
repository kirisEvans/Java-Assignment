package assignment3;

import java.util.Scanner;

public class assignment32 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int p = input.nextInt();
        int k = input.nextInt();
        int[][] matrix_a = new int[n][m];
        int[][] matrix_b = new int[m][p];
        int[][] matrix_c = new int[n][p];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix_a[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                matrix_b[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int l = 0; l < m; l++) {
                    if ((l+1) % k != 0){
                        matrix_c[i][j] += matrix_a[i][l] * matrix_b[l][j];
                    }
                    else {
                        matrix_c[i][j] -= matrix_a[i][l] * matrix_b[l][j];
                    }
                }
            }
        }

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix_c[j][i] + " ");
            }
            System.out.println(matrix_c[n-1][i]);
        }

    }
}
