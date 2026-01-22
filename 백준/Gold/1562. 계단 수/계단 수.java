import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][][] dp = new int[N+1][10][(1 << 10)];
        int INF = 1_000_000_000;

        for (int i = 1; i <= 9;i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int len = 2; len <= N;len++) {
            for (int i = 0 ; i <= 9;i++) {
                for (int j = 1;j < 1024;j++) {
                    int nxt = j | (1 << i);
                    if (i == 0) {
                        dp[len][i][nxt] += dp[len - 1][i+1][j];
                    } else if (i == 9) {
                        dp[len][i][nxt] += dp[len - 1][i-1][j];
                    } else {
                        dp[len][i][nxt] += (dp[len - 1][i - 1][j] + dp[len - 1][i+ 1][j]) % INF;
                    }

                    dp[len][i][nxt] %= INF;
                }
            }
        }
        int ans = 0;
        for (int i =0;i<=9;i++) {
            ans += dp[N][i][1023];
            ans %= INF;
        }

        System.out.println(ans);
        
    }
}