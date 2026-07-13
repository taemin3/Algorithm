import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] map = new int[N][N];
        for (int i = 0;i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0 ; i < N;i++) {
            for (int j = 0; j < N - 2;j++) {
                int count = 0 ;
                for (int k = 0;k < 3;k++) {
                    if (map[i][j + k] == 1) count++;
                }
                if (count > max) max = count;
            }
        }
        System.out.println(max);

    }
}