import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] indeg = new int[N+1];
        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N;i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indeg[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1;i <= N;i++) {
            if (indeg[i] == 0) {
                pq.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            list.add(cur);
            for (int g : graph[cur]) {
                indeg[g]--;
                if (indeg[g] == 0) {
                    pq.offer(g);
                }
            }
        }

        for (int i = 0 ; i < N;i++) {
            System.out.print(list.get(i) + " ");
        }
        
    }
}