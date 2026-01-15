import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][2];
        long [][] dp = new long[N][N];

        for (int i = 0; i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            
        }

        long INF = Long.MAX_VALUE;
        
        for (int i = 0 ; i < N;i++) {
            Arrays.fill(dp[i],INF);
        }

        for (int i = 0; i < N;i++) {
            dp[i][i] = 0;
        }

        for (int len = 2; len <= N;len++) {
            for (int i = 0; i + len - 1 <N;i++) {
                int j = i + len - 1;
                for (int k = i; k < j;k++) {
                    long cost = dp[i][k] + dp[k+1][j] + arr[i][0] * arr[k][1] * arr[j][1];
                    if (cost < dp[i][j]) dp[i][j] = cost;
                }
            }
        }
        System.out.println(dp[0][N-1]);
        
    }
}