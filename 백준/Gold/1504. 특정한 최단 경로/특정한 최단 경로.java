import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
   
    static List<int[]>[] graph;
    static int n ;
    static int INF = 200000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
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
            graph[b].add(new int[] {a, w});
            
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        long answer1 = dijk(1,v1) + dijk(v1,v2) + dijk(v2,n);
        long answer2 = dijk(1,v2) + dijk(v2,v1) + dijk(v1,n);
        long anw = Math.min(answer1,answer2);
        anw = (anw >= INF) ? -1 : anw;
        System.out.println(anw);
    }

    public static int dijk(int start, int target) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{start,0});
        int [] dist = new int[n + 1];
        
        Arrays.fill(dist,INF);
        dist[start] = 0;
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int c = cur[0];
            int w = cur[1];
            if (w > dist[c]) continue;
            for (int[] g : graph[c]) {
                int nw = g[1] + w;
                if (nw < dist[g[0]]) {
                    pq.offer(new int[]{g[0], nw});
                    dist[g[0]] = nw;
                }
            }
        }
        return dist[target];
    }

   
}