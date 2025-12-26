import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Edge {
        int from, to, w;
        Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0;i < tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            List<Edge> edges = new ArrayList<>();

            for (int j = 0; j < m;j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                edges.add(new Edge(a,b,c));
                edges.add(new Edge(b,a,c));
            }

            for (int j = 0; j < w;j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                edges.add(new Edge(a,b,-c));
            }
            boolean answer = bellman(edges, n);
            System.out.println((answer)? "YES":"NO");
        }
       
    }

    public static boolean bellman(List<Edge> edges, int n) {
        long[] dist = new long[n+1];
        Arrays.fill(dist,0);

        for (int i = 1;i <=n;i++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.to] > dist[e.from] + e.w) {
                    dist[e.to] = dist[e.from] + e.w;
                    updated = true;
                    if (i == n) return true;
                }
            }
            if (!updated) break;
        }
        return false;
    }


   
}