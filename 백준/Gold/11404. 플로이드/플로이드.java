import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n, m;
    static List<int[]>[] graph;
    static int[][] anw;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        anw = new int[n][n];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0;i < m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b,w});
        }
        for (int i = 1;i <= n;i++ ){
            dijk(i);
        }

        for (int i = 0;i<n;i++) {
            for (int j = 0;j < n;j++) {
                System.out.print(anw[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dijk(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int [] dist = new int[n + 1];
        Arrays.fill(dist,20000000);
        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            if (dist[now] != cost) continue;
            for (int[] g : graph[now]) {
                if (g[1] + cost < dist[g[0]]) {
                    dist[g[0]] = g[1] + cost;
                    pq.offer(new int[]{g[0], g[1] + cost});
                }
            }
        }
        for (int i = 0;i < n;i++) {
            if (dist[i + 1] == 20000000) {
                anw[start-1][i] = 0; 
            } else {
                anw[start-1][i] = dist[i+1];
            }
            
        }
    }
    
     
}