import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int [][] map;
    static int n;
    static long b;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        map = new int[n][n];

        for (int i =0; i < n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = pow(map, b);
        for (int i =0; i < n;i++) {
            
            for (int j = 0; j < n;j++) {
                System.out.print(result[i][j]  + " ");
            }

            System.out.println();
        }
        
    }

    public static int[][] pow(int [][] base , long exp) {
        if (exp == 1) {
            return base;
        }

        int [][] half = pow(base,exp/2);
        int [][] result = multi(half,half);

        if (exp % 2 == 1) {
            result = multi(result, base);
        }
        return result;
        
    }

    public static int[][] multi(int [][] a,int [][] b) {
        int [][] res = new int[n][n];
        for(int i = 0; i < n;i++) {
            for (int j = 0; j < n;j++) {
                long sum = 0;
                for (int k = 0; k < n;k++) {
                    sum += a[i][k] * b[k][j];
                }
                res[i][j] = (int) (sum % 1000);
            }
        }
        return res;
    }
}