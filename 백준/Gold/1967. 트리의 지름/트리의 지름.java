import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
   
    static List<int[]>[] graph;
    static int n ;
    static int[] dist;
    static int INF = 20000000;
    static boolean [] visit;
    static int max = 0;
    static int far = 1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

       
        n = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n;i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < n - 1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, w});
            graph[b].add(new int[]{a, w});
            
            
        }
        visit = new boolean[n + 1];
        dfs(1, 0);
        visit = new boolean[n + 1];
        max = 0;
        dfs(far, 0);
        System.out.println(max);
       
    }

    public static void dfs(int start, int dist) {
         visit[start] = true;
        if (dist > max) {
                    max = dist;
                    far = start;
                   
                }
        
        for (int [] g :graph[start]) {
            if (!visit[g[0]]) {
                int newd = dist + g[1];
                
                 dfs(g[0], newd);
            }
        }
    }

   
}