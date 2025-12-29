import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int n, m;
    static List<int[]>[] graph;
    static int[] dist;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for (int i = 1;i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b,c});
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        dijk(s,t);
        System.out.println(dist[t]);
        List<Integer> list = new ArrayList<>();
        list.add(t);
        while(true) {
            if (arr[t] == 0) {
                break;
            } else {
                list.add(arr[t]);
                t = arr[t];
            }
        }
        int [] anw = new int[list.size()];
        int idx = 0;
        for (int i = list.size() - 1; i >= 0 ; i--) {
            anw[idx++] = list.get(i);
        }
        System.out.println(list.size());
        for (int i = 0 ; i < list.size();i++) {
            System.out.print(anw[i] + " ");
        }
    }

    

    public static void dijk(int start, int target) {
        dist = new int[n+ 1];
        arr = new int[n+1];
        
        Arrays.fill(dist,20000000);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            if (now == target) break;
            if (cost != dist[now]) continue;
            for (int [] nx : graph[now]) {
                if (nx[1] + cost < dist[nx[0]]) {
                    dist[nx[0]] = nx[1] + cost;
                    arr[nx[0]] = now;
                    pq.offer(new int[]{nx[0],nx[1] + cost});
                }
            }
        }
    }
}