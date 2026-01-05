import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static List<Integer>[] graph;
    static boolean [] visit;
    static int [] count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        count = new int[n+1];
        Arrays.fill(count,1);
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(r);
        for (int i = 0; i < q;i++) {
            System.out.println(count[Integer.parseInt(br.readLine())]);
        }

        
        
    }

    public static int dfs(int r) {
        visit[r] = true;
        for (int g : graph[r]) {
            if (!visit[g]) {
                count[r] += dfs(g);
            }
        }

        return count[r];
    }
}