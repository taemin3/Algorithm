import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n;
    static List<int[]>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n;i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while(true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) break;
                int c = Integer.parseInt(st.nextToken());
                graph[a].add(new int[]{b,c});
                graph[b].add(new int[]{a,c});
            }
        }
        int[] arr = dijk(1);
        int[] anw = dijk(arr[0]);
        System.out.println(anw[1]);
        
    }

    public static int[] dijk(int start) {
        int [] dist = new int[n + 1];
        Arrays.fill(dist,100000000);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{start,0});
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            if (cost != dist[now]) continue;
            for (int[] nx : graph[now]) {
                int next = nx[0];
                int w = nx[1];

                if (w + cost < dist[next]) {
                    dist[next] = w + cost;
                    pq.offer(new int[]{next, w+cost});
                }
            }
        }
        int max = 0;
        int ans = 0;
        for (int i = 1; i <= n;i++) {
            if (dist[i] > max) {
                max = dist[i];
                ans = i;
            }
            
        }
        return new int[]{ans, max};
    }
}