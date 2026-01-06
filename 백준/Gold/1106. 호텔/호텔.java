import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int INF = 1000000000;
        
        int [] dp = new int[c + 101];
        Arrays.fill(dp,INF);
        dp[0] = 0;
        int [][] arr = new int[n][2];
        for (int i = 0 ; i < n;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < n;i++) {
            int p = arr[i][0];
            int q = arr[i][1];
            for (int j = q; j < c + 101;j++) {
                if (dp[j - q] != INF) {
                    dp[j] = Math.min(dp[j],dp[j-q] + p);
                }
            }
            
        }
        int ans = INF;
        for (int i = c;i < c + 101;i++) {
            ans = Math.min(ans,dp[i]);
        }
        System.out.println(ans);
    }
}