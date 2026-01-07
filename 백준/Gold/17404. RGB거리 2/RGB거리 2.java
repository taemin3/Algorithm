import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][3];
        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            
        }
        
        int ans = Integer.MAX_VALUE;
        for (int p = 0 ; p < 3 ; p++) {
            int [][] dp= new int[N][3];
            for (int c = 0; c < 3;c++) dp[0][c] = 100000000;
            dp[0][p] = arr[0][p];

            for (int i = 1; i < N;i++) {
                
                    dp[i][0] = arr[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
                    dp[i][1] = arr[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
                    dp[i][2] = arr[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
                
            }
            for (int i = 0 ; i < 3;i++) {
                if (i == p) continue;
    
                ans = Math.min(ans, dp[N-1][i]);
            }

        }
        System.out.println(ans);


        
        
    }

    

    
}