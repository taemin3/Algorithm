import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static List<Integer>[] graph;
    static int N;
    static int [][] dp;
    static boolean [] visit;
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        dp = new int[N+1][2];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N;i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        int ans = Math.min(dp[1][0],dp[1][1]);
        System.out.println(ans);
        
        
    }
    static void dfs(int s) {
        visit[s] = true;
        dp[s][0] = 0;
        dp[s][1] = 1;
        for (int g :graph[s]) {
            if (!visit[g]) {
                dfs(g);
                dp[s][0] += dp[g][1];
                dp[s][1] += Math.min(dp[g][0],dp[g][1]);
            }
        }
    }

    
}