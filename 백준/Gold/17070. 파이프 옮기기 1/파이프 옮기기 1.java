import java.util.*;
import java.io.*;
public class Main {
    
    static int [][] array;
    static int n;
    static int count = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        for (int i = 0;i < n ;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n;j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs15(0,1,0);
        System.out.println(count);
    }

    public static void dfs15(int x,int y, int dir) {
        if (x == n - 1 && y == n - 1) {
            count++;
            return;
        }

        if (dir == 0) {
            if (y + 1 < n  && array[x][y+1] == 0 ) {
                dfs15(x,y+1,0);

            }
            if (x + 1 < n && y + 1 < n && array[x][y+1] == 0 && array[x+1][y] == 0 &&
                array[x+1][y+1] == 0 ) {
                dfs15(x + 1,y+1, 1);

            }
        } else if (dir == 1) {
            if (y + 1 < n  && array[x][y+1] == 0 ) {
                dfs15(x,y+1,0);
            }
            if (x + 1 < n && y + 1 < n && array[x][y+1] == 0 && array[x+1][y] == 0 &&
                    array[x+1][y+1] == 0 ) {
                dfs15(x + 1,y+1, 1);
            }

            if (x + 1 < n &&  array[x+1][y] == 0 ) {
                dfs15(x + 1,y, 2);
            }
        } else if (dir == 2) {
            if (x + 1 < n && y + 1 < n && array[x][y+1] == 0 && array[x+1][y] == 0 &&
                    array[x+1][y+1] == 0 ) {
                dfs15(x + 1,y+1, 1);
            }

            if (x + 1 < n && array[x+1][y] == 0 ) {
                dfs15(x + 1,y, 2);
            }
        }
    }}