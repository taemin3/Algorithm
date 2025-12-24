import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int [][] map;
    static boolean [][] visit;
    static int n, m, r;
    static int anw = 0;
    static int [] item;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n + 1];
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n;i++) {
            Arrays.fill(map[i],20000000); 
            map[i][i] = 0;
        }
        
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n;i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0;i < r;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[a][b] = w;
            map[b][a] = w;
        }

        for (int k = 1; k <= n;k++) {
            for (int i = 1; i <= n; i++) {
                if (map[i][k] == 20000000) continue;
                for (int j = 1; j <= n; j++) {
                    if (map[k][j] == 20000000) continue;
                    int nd = map[i][k] + map[k][j];
                    if (nd < map[i][j]) {
                        map[i][j] = nd;
                    }
                }
            }
        }
        int max = 0;
        for (int i =1 ; i <= n;i++) {
            int result = 0;
            for(int j = 1; j <= n;j++) {
                if (map[i][j] <= m) {
                    result += item[j];
                }
            }
            max = Math.max(result,max);
        }
        System.out.println(max);
    }

    


}