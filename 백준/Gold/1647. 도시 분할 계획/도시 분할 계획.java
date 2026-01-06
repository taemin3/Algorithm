import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int[] parent;
    static int[] rank;

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    } 

    public static boolean union(int a , int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return false;
        parent[rb] = ra;
        return true;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        rank = new int[N+1];
        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i <= N;i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a,b,c));
        }

        Collections.sort(edges);

        long ans = 0;
        int count = 0;
        int max = 0;
        for (Edge e : edges ) {
            if (union(e.u,e.v)) {
                ans += e.w;
                count++;
                max = Math.max(e.w,max);
                if (count == N - 1) break;
            }
        }
        System.out.println(ans - max);
        
        
        
    }
}