import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static List<int[]>[] graph;
    static int n, m, x;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1;i <= n;i++ ){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b,w});
        }

        int[] ans = dijk(x, -1);
        ans[0] = 0;
        for (int i = 1; i < ans.length;i++) {
            int [] result = dijk(i,x);
            ans[i] += result[0];
        }
        Arrays.sort(ans);
        System.out.println(ans[ans.length - 1]);
        
        
    }

    public static int[] dijk(int start, int target) {
        int [] dist = new int[n + 1];
        Arrays.fill(dist,20000000);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            if (now == target) return new int[]{cost};
            if  (cost != dist[now]) continue;
            for (int[] nx : graph[now]) {
                if (nx[1] + cost < dist[nx[0]]) {
                    
                    dist[nx[0]] = nx[1] + cost;
                    pq.offer(new int[]{nx[0], nx[1]+cost});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n;i++){
            
            max = Math.max(max, dist[i]);
        }
        return dist;
    }

   
}