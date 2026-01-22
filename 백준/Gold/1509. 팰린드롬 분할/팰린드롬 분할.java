import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        boolean [][] pal = new boolean[n][n];

        for (int i =0; i < n;i++) {
            pal[i][i] = true;
        }

        for (int i =0; i < n - 1;i++) {
            if (s.charAt(i) == s.charAt(i+1)) pal[i][i+1] = true;
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n;i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && pal[i+1][j-1]) pal[i][j] = true;
            } 
        }

        int [] dp = new int[n+1];

        Arrays.fill(dp,10000000);
        dp[0] = 0;

        for (int i = 1; i <= n;i++) {
            for (int j = 0;j < i;j++){
                if (pal[j][i-1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(dp[n]);

        
        
    }
}