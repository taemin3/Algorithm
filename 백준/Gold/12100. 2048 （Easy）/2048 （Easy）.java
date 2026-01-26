import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int [][] map = new int[N][N];
        
        for (int i = 0 ; i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(map,0);
        System.out.println(ans);
    }

    static void dfs(int[][] map, int depth) {
        ans = Math.max(ans,max(map));
        if (depth == 5) return;

        
        for (int i = 0; i < 4;i++) {
            int[][] m = move(map,i);
            dfs(m,depth + 1);
        }
    }

    static int[][] move (int[][] map, int dir)  {
        int [][] res = new int[N][N];
        if (dir == 2) {
            for (int i = 0 ; i < N;i++) {
                int idx = 0;
                int block = 0;
                for (int j = 0 ; j < N;j++) {
                    int v = map[i][j];
                    if (v == 0) continue;
                    if (block == v) {
                        res[i][idx - 1] = v * 2;
                        block = 0;
                    } else {
                        block = v;
                        res[i][idx] = block;
                        idx++;
                    }
                }
            }
        } else if (dir == 3) {
            for (int i = 0 ; i < N;i++) {
                int idx = N - 1;
                int block = 0;
                for (int j = N - 1 ; j >= 0;j--) {
                    int v = map[i][j];
                    if (v == 0) continue;
                    if (block == v) {
                        res[i][idx + 1] = v * 2;
                        block = 0;
                    } else {
                        block = v;
                        res[i][idx] = block;
                        idx--;
                    }
                }
            }
        } else if (dir == 0) {
            for (int j = 0 ; j < N;j++) {
                int idx = 0;
                int block = 0;
                for (int i = 0 ; i < N;i++) {
                    int v = map[i][j];
                    if (v == 0) continue;
                    if (block == v) {
                        res[idx - 1][j] = v * 2;
                        block = 0;
                    } else {
                        block = v;
                        res[idx][j] = block;
                        idx++;
                    }
                }
            }
        } else if (dir == 1) {
            for (int j = 0 ; j < N;j++) {
                int idx = N - 1;
                int block = 0;
                for (int i = N - 1 ; i >= 0;i--) {
                    int v = map[i][j];
                    if (v == 0) continue;
                    if (block == v) {
                        res[idx + 1][j] = v * 2;
                        block = 0;
                    } else {
                        block = v;
                        res[idx][j] = block;
                        idx--;
                    }
                }
            }
        }
        return res;
    }

    static int max(int [][] map) {
        int m = 0;
        for (int i = 0 ; i < N;i++) {
            for (int j = 0;j < N;j++) {
                m = Math.max(m, map[i][j]);
            }
        }
        return m;
    }

   
}