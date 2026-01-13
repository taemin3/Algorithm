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
        List<Integer> [] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N;i++) {
            graph[i] = new ArrayList<>();
        }
        int [] indeg = new int[N+1];
        for (int i = 0 ; i < M;i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indeg[b]++;
        }
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N;i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur + " ");
            for (int g : graph[cur]) {
                indeg[g]--;
                if (indeg[g] == 0) q.offer(g);
            }
        }
        System.out.println(sb.toString());
           
    }
}