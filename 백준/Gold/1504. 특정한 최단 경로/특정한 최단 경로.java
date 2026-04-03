import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static List<int[]>[] graph;
    static int INF = 100000000;
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 1 ; i <= N;i++) {
            graph[i] = new ArrayList<>();
        }

        
        
        for (int i = 0; i < E;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,c});
            graph[b].add(new int[]{a,c});
            
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        long ans1 = dijk(1,v1) + dijk(v1,v2) + dijk(v2,N);
        long ans2 = dijk(1,v2) + dijk(v2,v1) + dijk(v1,N);
        

        long ans = Math.min(ans1,ans2);
        if (ans >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
        
    }

    public static long dijk(int s, int t) {
        long ans = INF;
        int [] dist = new int[N + 1];
        Arrays.fill(dist,INF);
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{s,0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            
            if (dist[now] != cost) continue; 
            if (now == t) {
                ans = cost;
                break;
            } 
            for (int [] nxt: graph[now]) {
                if (cost + nxt[1] < dist[nxt[0]]) {
                    dist[nxt[0]] = cost + nxt[1];
                    pq.offer(new int[]{nxt[0],cost + nxt[1]});
                }
            }
        }
        return ans;
        
    }

    
    
}