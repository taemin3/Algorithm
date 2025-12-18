import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
   
    static List<int[]>[] graph;
    static int n ;
    static int[] dist;
    static int INF = 20000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n;i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < e;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, w});
            
            
        }
        dijk(start);
        for (int i = 1; i <= n; i++) {
            System.out.println((dist[i] == INF) ? "INF" : dist[i]);
        }
       
    }

    public static void dijk(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{start,0});
        dist = new int[n + 1];
        
        Arrays.fill(dist,INF);
        dist[start] = 0;
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int c = cur[0];
            int w = cur[1];
            if (w != dist[c]) continue;
            for (int[] g : graph[c]) {
                int nw = g[1] + w;
                if (nw < dist[g[0]]) {
                    pq.offer(new int[]{g[0], nw});
                    dist[g[0]] = nw;
                }
            }
        }
        
    }

   
}