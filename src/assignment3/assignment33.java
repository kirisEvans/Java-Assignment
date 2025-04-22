package assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class assignment33 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        char[][] matrix = new char[n+2][m+2];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                matrix[i][j] = input.next().charAt(0);
            }
        }
        String my_old = input.next();
        String my_new = input.next();

        char[][] result = clockwise(matrix, n+2, m+2, my_old, my_new);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] clockwise(char[][] my_matrix, int row, int col, String before, String after){
        StringBuilder rune = new StringBuilder(Character.toString(my_matrix[1][1]));
        ArrayList<int[]> my_coordinates = new ArrayList<>();
        my_coordinates.add(new int[] {0, 0});
        my_matrix[1][1] = 0;
        int x = 1;
        int y = 1;
        while (rune.length() != (row-2) * (col-2)){
            while (my_matrix[x][y+1] != 0){ //向右
                rune.append(my_matrix[x][y+1]);
                my_matrix[x][y+1] = 0;
                my_coordinates.add(new int[] {x-1, y});
                y++;
            }

            while (my_matrix[x+1][y] != 0){ //向下
                rune.append(my_matrix[x+1][y]);
                my_matrix[x+1][y] = 0;
                my_coordinates.add(new int[] {x, y-1});
                x++;
            }

            while (my_matrix[x][y-1] != 0){ //向左
                rune.append(my_matrix[x][y-1]);
                my_matrix[x][y-1] = 0;
                my_coordinates.add(new int[] {x-1, y-2});
                y--;
            }

            while (my_matrix[x-1][y] != 0){ //向上
                rune.append(my_matrix[x-1][y]);
                my_matrix[x-1][y] = 0;
                my_coordinates.add(new int[] {x-2, y-1});
                x--;
            }
        }
        String my_result = rune.toString().replaceAll(before, after);
        char[][] fin_list = new char[row-2][col-2];
        for (int i = 0; i < my_coordinates.size(); i++) {
            char ch = my_result.charAt(i);
            fin_list[my_coordinates.get(i)[0]][my_coordinates.get(i)[1]] = ch;
        }
        return fin_list;
    }
}
