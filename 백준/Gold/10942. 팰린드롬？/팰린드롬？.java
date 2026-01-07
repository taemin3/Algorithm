import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int [] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean [][] dp = new boolean[N][N];

        for (int i = 0 ; i < N;i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < N - 1;i++) {
            if (arr[i] == arr[i+1]) dp[i][i+1] = true;
        }

        for (int len = 3; len <= N;len++) {
            for (int i = 0 ; i + len - 1 < N ; i++) {
                int e = i + len - 1;
                if (arr[i] == arr[e] && dp[i + 1][e - 1]) dp[i][e] =true;
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[a-1][b-1] ? "1" : "0").append("\n");
        }
        System.out.print(sb.toString());
    }

    

    
}