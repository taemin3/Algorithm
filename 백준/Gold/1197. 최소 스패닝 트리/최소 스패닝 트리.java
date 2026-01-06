import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[] parent;
    static int[] rank;

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u,int v,int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a,int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return false;

        parent[ra] = rb;
        return true;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        rank = new int[V+1];

        for (int i = 1;i <= V;i++){
            parent[i] = i;
        }

        Edge [] edges = new Edge[E];

        for (int i = 0 ; i < E;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a,b,c);
            
        }

        Arrays.sort(edges);
        int count = 0;
        int ans = 0;
        for (Edge e : edges) {
            if (union(e.u,e.v)) {
                ans += e.w;
                count++;
                if (count == V -1) break;
            }
        }
        System.out.println(ans);
        
    }
}