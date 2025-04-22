package assignment2;

import java.util.Scanner;

public class assignment23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] cats = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j =0; j < n; j++){
                cats[i][j] = input.nextInt();
            }
        }

        int x = input.nextInt();
        int y = input.nextInt();
        x -= 1;
        y -= 1;

        if (cats[x][y] == -1){
            if (m == 1 & n == 1){
                System.out.println("DATA CANNOT BE REPAIRED");
            }
            else if (m == 1){
                if (y == 0 | y == n-1){
                    System.out.println("DATA CANNOT BE REPAIRED");
                }
                else {
                    if (cats[x][y-1] != -1 & cats[x][y+1] != -1){
                        cats[x][y] = (int) (cats[x][y-1] * 0.4 + cats[x][y+1] * 0.6);
                        System.out.println(cats[x][y]);
                    }
                    else {
                        System.out.println("DATA CANNOT BE REPAIRED");
                    }
                }
            }
            else if (n == 1){
                if (x == 0 | x == m-1){
                    System.out.println("DATA CANNOT BE REPAIRED");
                }
                else {
                    if (cats[x-1][y] != -1 & cats[x+1][y] != -1){
                        cats[x][y] = (int) (cats[x][y-1] * 0.5 + cats[x][y+1] * 0.5);
                        System.out.println(cats[x][y]);
                    }
                    else {
                        System.out.println("DATA CANNOT BE REPAIRED");
                    }
                }
            }
            else {
                if (x == 0){
                    if (y == 0){
                        if (cats[x+1][y] != -1 & cats[x][y+1] != -1){
                            cats[x][y] = (int) (cats[x+1][y] * 0.4 + cats[x][y+1] * 0.6);
                            System.out.println(cats[x][y]);
                        }
                        else {
                            System.out.println("DATA CANNOT BE REPAIRED");
                        }
                    }
                    else if (y == n-1){
                        if (cats[x+1][y] != -1 & cats[x][y-1] != -1){
                            cats[x][y] = (int) (cats[x+1][y] * 0.4 + cats[x][y-1] * 0.6);
                            System.out.println(cats[x][y]);
                        }
                    }
                    else {
                        if (cats[x+1][y] == -1){
                            if (cats[x][y-1] != -1 & cats[x][y+1] != -1){
                                cats[x][y] = (int) (cats[x][y-1] * 0.4 + cats[x][y+1] * 0.6);
                                System.out.println(cats[x][y]);
                            }
                            else {
                                System.out.println("DATA CANNOT BE REPAIRED");
                            }
                        }
                        else {
                            if (cats[x][y-1] != -1 & cats[x][y+1] != -1){
                                cats[x][y] = (int) (cats[x][y-1] * 0.4 + cats[x][y+1] * 0.4 + cats[x+1][y] * 0.2);
                                System.out.println(cats[x][y]);
                            }
                            else if (cats[x][y-1] != -1){
                                cats[x][y] = (int) (cats[x][y-1] * 0.6 + cats[x+1][y] * 0.4);
                                System.out.println(cats[x][y]);
                            }
                            else if (cats[x][y+1] != -1){
                                cats[x][y] = (int) (cats[x][y+1] * 0.6 + cats[x+1][y] * 0.4);
                                System.out.println(cats[x][y]);
                            }
                            else {
                                System.out.println("DATA CANNOT BE REPAIRED");
                            }
                        }
                    }
                }
                else if (x == m-1){
                    if (y == 0){
                        if (cats[x-1][y] != -1 & cats[x][y+1] != -1){
                            cats[x][y] = (int) (cats[x-1][y] * 0.4 + cats[x][y+1] * 0.6);
                            System.out.println(cats[x][y]);
                        }
                        else {
                            System.out.println("DATA CANNOT BE REPAIRED");
                        }
                    }
                    else if (y == n-1){
                        if (cats[x-1][y] != -1 & cats[x][y-1] != -1){
                            cats[x][y] = (int) (cats[x-1][y] * 0.4 + cats[x][y-1] * 0.6);
                            System.out.println(cats[x][y]);
                        }
                    }
                    else {
                        if (cats[x-1][y] == -1){
                            if (cats[x][y-1] != -1 & cats[x][y+1] != -1){
                                cats[x][y] = (int) (cats[x][y-1] * 0.4 + cats[x][y+1] * 0.6);
                                System.out.println(cats[x][y]);
                            }
                            else {
                                System.out.println("DATA CANNOT BE REPAIRED");
                            }
                        }
                        else {
                            if (cats[x][y-1] != -1 & cats[x][y+1] != -1){
                                cats[x][y] = (int) (cats[x][y-1] * 0.4 + cats[x][y+1] * 0.4 + cats[x-1][y] * 0.2);
                                System.out.println(cats[x][y]);
                            }
                            else if (cats[x][y-1] != -1){
                                cats[x][y] = (int) (cats[x][y-1] * 0.6 + cats[x-1][y] * 0.4);
                                System.out.println(cats[x][y]);
                            }
                            else if (cats[x][y+1] != -1){
                                cats[x][y] = (int) (cats[x][y+1] * 0.6 + cats[x-1][y] * 0.4);
                                System.out.println(cats[x][y]);
                            }
                            else {
                                System.out.println("DATA CANNOT BE REPAIRED");
                            }
                        }
                    }
                }
                else {
                    if (y == 0){
                        if (cats[x-1][y] != -1 & cats[x+1][y] != -1 & cats[x][y+1] != -1){
                            cats[x][y] = (int) (cats[x-1][y] * 0.35 + cats[x+1][y] * 0.35 + cats[x][y+1] * 0.3);
                            System.out.println(cats[x][y]);
                        }
                        else if (cats[x][y+1] == -1){
                            if (cats[x-1][y] != -1 & cats[x+1][y] != -1){
                                cats[x][y] = (int) (cats[x-1][y] * 0.5 + cats[x+1][y] * 0.5);
                                System.out.println(cats[x][y]);
                            }
                            else {
                                System.out.println("DATA CANNOT BE REPAIRED");
                            }
                        }
                        else if (cats[x-1][y] == -1){
                            if (cats[x+1][y] != -1 & cats[x][y+1] != -1){
                                cats[x][y] = (int) (cats[x+1][y] * 0.4 + cats[x][y+1] * 0.6);
                                System.out.println(cats[x][y]);
                            }
                            else {
                                System.out.println("DATA CANNOT BE REPAIRED");
                            }
                        }
                        else if (cats[x+1][y] == -1){
                            if (cats[x-1][y] != -1 & cats[x][y+1] != -1){
                                cats[x][y] = (int) (cats[x-1][y] * 0.4 + cats[x][y+1] * 0.6);
                                System.out.println(cats[x][y]);
                            }
                            else {
                                System.out.println("DATA CANNOT BE REPAIRED");
                            }
                        }
                    }

                    else if (y == n-1){
                        if (cats[x-1][y] != -1 & cats[x+1][y] != -1 & cats[x][y-1] != -1){
                            cats[x][y] = (int) (cats[x-1][y] * 0.35 + cats[x+1][y] * 0.35 + cats[x][y-1] * 0.3);
                            System.out.println(cats[x][y]);
                        }
                        else if (cats[x][y-1] == -1){
                            if (cats[x-1][y] != -1 & cats[x+1][y] != -1){
                                cats[x][y] = (int) (cats[x-1][y] * 0.5 + cats[x+1][y] * 0.5);
                                System.out.println(cats[x][y]);
                            }
                            else {
                                System.out.println("DATA CANNOT BE REPAIRED");
                            }
                        }
                        else if (cats[x-1][y] == -1){
                            if (cats[x+1][y] != -1 & cats[x][y-1] != -1){
                                cats[x][y] = (int) (cats[x+1][y] * 0.4 + cats[x][y-1] * 0.6);
                                System.out.println(cats[x][y]);
                            }
                            else {
                                System.out.println("DATA CANNOT BE REPAIRED");
                            }
                        }
                        else if (cats[x+1][y] == -1){
                            if (cats[x-1][y] != -1 & cats[x][y-1] != -1){
                                cats[x][y] = (int) (cats[x-1][y] * 0.4 + cats[x][y-1] * 0.6);
                                System.out.println(cats[x][y]);
                            }
                            else {
                                System.out.println("DATA CANNOT BE REPAIRED");
                            }
                        }
                    }
                    else {
                        if (cats[x - 1][y] != -1 & cats[x + 1][y] != -1 & cats[x][y - 1] != -1 & cats[x][y + 1] != -1) {
                            cats[x][y] = (int) (cats[x - 1][y] * 0.2 + cats[x + 1][y] * 0.2 + cats[x][y - 1] * 0.3 + cats[x][y + 1] * 0.3);
                            System.out.println(cats[x][y]);
                        } else if (cats[x - 1][y] == -1) {
                            if (cats[x + 1][y] == -1) {
                                if (cats[x][y - 1] != -1 & cats[x][y + 1] != -1) {
                                    cats[x][y] = (int) (cats[x][y - 1] * 0.4 + cats[x][y + 1] * 0.6);
                                    System.out.println(cats[x][y]);
                                } else {
                                    System.out.println("DATA CANNOT BE REPAIRED");
                                }
                            } else {
                                if (cats[x][y - 1] != -1 & cats[x][y + 1] != -1) {
                                    cats[x][y] = (int) (cats[x][y - 1] * 0.4 + cats[x][y + 1] * 0.4 + cats[x + 1][y] * 0.2);
                                    System.out.println(cats[x][y]);
                                } else if (cats[x][y - 1] != -1) {
                                    cats[x][y] = (int) (cats[x][y - 1] * 0.6 + cats[x + 1][y] * 0.4);
                                    System.out.println(cats[x][y]);
                                } else if (cats[x][y + 1] != -1) {
                                    cats[x][y] = (int) (cats[x][y + 1] * 0.6 + cats[x + 1][y] * 0.4);
                                    System.out.println(cats[x][y]);
                                } else {
                                    System.out.println("DATA CANNOT BE REPAIRED");
                                }
                            }
                        } else if (cats[x + 1][y] == -1) {
                            if (cats[x - 1][y] == -1) {
                                if (cats[x][y - 1] != -1 & cats[x][y + 1] != -1) {
                                    cats[x][y] = (int) (cats[x][y - 1] * 0.4 + cats[x][y + 1] * 0.6);
                                    System.out.println(cats[x][y]);
                                } else {
                                    System.out.println("DATA CANNOT BE REPAIRED");
                                }
                            } else {
                                if (cats[x][y - 1] != -1 & cats[x][y + 1] != -1) {
                                    cats[x][y] = (int) (cats[x][y - 1] * 0.4 + cats[x][y + 1] * 0.4 + cats[x - 1][y] * 0.2);
                                    System.out.println(cats[x][y]);
                                } else if (cats[x][y - 1] != -1) {
                                    cats[x][y] = (int) (cats[x][y - 1] * 0.6 + cats[x - 1][y] * 0.4);
                                    System.out.println(cats[x][y]);
                                } else if (cats[x][y + 1] != -1) {
                                    cats[x][y] = (int) (cats[x][y + 1] * 0.6 + cats[x - 1][y] * 0.4);
                                    System.out.println(cats[x][y]);
                                } else {
                                    System.out.println("DATA CANNOT BE REPAIRED");
                                }
                            }
                        } else if (cats[x][y - 1] == -1) {
                            if (cats[x - 1][y] != -1 & cats[x + 1][y] != -1 & cats[x][y + 1] != -1) {
                                cats[x][y] = (int) (cats[x - 1][y] * 0.35 + cats[x + 1][y] * 0.35 + cats[x][y + 1] * 0.3);
                                System.out.println(cats[x][y]);
                            } else if (cats[x][y + 1] == -1) {
                                if (cats[x - 1][y] != -1 & cats[x + 1][y] != -1) {
                                    cats[x][y] = (int) (cats[x - 1][y] * 0.5 + cats[x + 1][y] * 0.5);
                                    System.out.println(cats[x][y]);
                                } else {
                                    System.out.println("DATA CANNOT BE REPAIRED");
                                }
                            } else if (cats[x - 1][y] == -1) {
                                if (cats[x + 1][y] != -1 & cats[x][y + 1] != -1) {
                                    cats[x][y] = (int) (cats[x + 1][y] * 0.4 + cats[x][y + 1] * 0.6);
                                    System.out.println(cats[x][y]);
                                } else {
                                    System.out.println("DATA CANNOT BE REPAIRED");
                                }
                            } else if (cats[x + 1][y] == -1) {
                                if (cats[x - 1][y] != -1 & cats[x][y + 1] != -1) {
                                    cats[x][y] = (int) (cats[x - 1][y] * 0.4 + cats[x][y + 1] * 0.6);
                                    System.out.println(cats[x][y]);
                                } else {
                                    System.out.println("DATA CANNOT BE REPAIRED");
                                }
                            }
                        } else if (cats[x][y + 1] == -1) {
                            if (cats[x - 1][y] != -1 & cats[x + 1][y] != -1 & cats[x][y - 1] != -1) {
                                cats[x][y] = (int) (cats[x - 1][y] * 0.35 + cats[x + 1][y] * 0.35 + cats[x][y - 1] * 0.3);
                                System.out.println(cats[x][y]);
                            } else if (cats[x][y - 1] == -1) {
                                if (cats[x - 1][y] != -1 & cats[x + 1][y] != -1) {
                                    cats[x][y] = (int) (cats[x - 1][y] * 0.5 + cats[x + 1][y] * 0.5);
                                    System.out.println(cats[x][y]);
                                } else {
                                    System.out.println("DATA CANNOT BE REPAIRED");
                                }
                            } else if (cats[x - 1][y] == -1) {
                                if (cats[x + 1][y] != -1 & cats[x][y - 1] != -1) {
                                    cats[x][y] = (int) (cats[x + 1][y] * 0.4 + cats[x][y - 1] * 0.6);
                                    System.out.println(cats[x][y]);
                                } else {
                                    System.out.println("DATA CANNOT BE REPAIRED");
                                }
                            } else if (cats[x + 1][y] == -1) {
                                if (cats[x - 1][y] != -1 & cats[x][y - 1] != -1) {
                                    cats[x][y] = (int) (cats[x - 1][y] * 0.4 + cats[x][y - 1] * 0.6);
                                    System.out.println(cats[x][y]);
                                } else {
                                    System.out.println("DATA CANNOT BE REPAIRED");
                                }
                            }
                        }
                    }
                }
            }
        }

        else {
            System.out.println(cats[x][y]);
        }
        input.close();
    }
}
