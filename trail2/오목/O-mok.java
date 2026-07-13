import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 15; j++) {
                if (arr[i][j] == 1 &&
                    arr[i][j+1] == 1 &&
                    arr[i][j+2] == 1 &&
                    arr[i][j+3] == 1 &&
                    arr[i][j+4] == 1 ) {
                        System.out.println("1");
                        System.out.println((i+1) + " " + (j+3));
                        return;
                    }
                if (arr[i][j] == 2 &&
                    arr[i][j+1] == 2 &&
                    arr[i][j+2] == 2 &&
                    arr[i][j+3] == 2 &&
                    arr[i][j+4] == 2 ) {
                        System.out.println("2");
                        System.out.println((i+1) + " " + (j+3));
                        return;
                    }
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 15; j++) {
                if (arr[j][i] == 1 &&
                    arr[j+1][i] == 1 &&
                    arr[j+2][i] == 1 &&
                    arr[j+3][i] == 1 &&
                    arr[j+4][i] == 1 ) {
                        System.out.println("1");
                        System.out.println((j + 3) + " " + (i+1));
                        return;
                    }
                if (arr[j][i] == 2 &&
                    arr[j+1][i] == 2 &&
                    arr[j+2][i] == 2 &&
                    arr[j+3][i] == 2 &&
                    arr[j+4][i] == 2 ) {
                        System.out.println("2");
                        System.out.println((j + 3) + " " +(i+1));
                        return;
                    }
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (arr[j][i] == 1 &&
                    arr[j+1][i+1] == 1 &&
                    arr[j+2][i+2] == 1 &&
                    arr[j+3][i+3] == 1 &&
                    arr[j+4][i+4] == 1 ) {
                        System.out.println("1");
                        System.out.println((j + 3) + " " + (i+3));
                        return;
                    }
                if (arr[j][i] == 2 &&
                    arr[j+1][i+1] == 2 &&
                    arr[j+2][i+2] == 2 &&
                    arr[j+3][i+3] == 2 &&
                    arr[j+4][i+4] == 2 ) {
                        System.out.println("2");
                        System.out.println((j + 3) + " " +(i+3));
                        return;
                    }
            }
        }

        for (int j = 0; j < 15; j++) {
            for (int i = 4; i < 19; i++) {
                if (arr[j][i] == 1 &&
                    arr[j+1][i-1] == 1 &&
                    arr[j+2][i-2] == 1 &&
                    arr[j+3][i-3] == 1 &&
                    arr[j+4][i-4] == 1 ) {
                        System.out.println("1");
                        System.out.println((j + 3) + " " + (i-1));
                        return;
                    }
                if (arr[j][i] == 2 &&
                    arr[j+1][i-1] == 2 &&
                    arr[j+2][i-2] == 2 &&
                    arr[j+3][i-3] == 2 &&
                    arr[j+4][i-4] == 2 ) {
                        System.out.println("2");
                        System.out.println((j + 3) + " " +(i-1));
                        return;
                    }
            }
        }
        System.out.println("0");
    }
}