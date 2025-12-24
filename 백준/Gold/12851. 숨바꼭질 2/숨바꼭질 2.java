import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dist;
    static int[] cnt;
    static int anw = 20000000;
    static int count = 0;
    static int k;
    static int best = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dist = new int[100001];
        cnt = new int[100001];
        Arrays.fill(dist,-1);
        dist[n] = 0;
        cnt[n] = 1;
        bfs(n);
        System.out.println(dist[k]);
        System.out.println(cnt[k]);
    }

    public static void bfs(int a) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        while(!q.isEmpty()) {
            int x = q.poll();

            if (best != -1 && dist[x] > best) break;
            int [] next = {x + 1, x - 1, x *2};
            for (int nx : next) {
                if (nx < 0 || nx > 100000) continue;
                if (dist[nx] == -1) {
                    dist[nx] = dist[x] + 1;
                    cnt[nx] = cnt[x];
                    q.offer(nx);
                } else if (dist[nx] == dist[x] + 1) {
                    cnt[nx] += cnt[x];
                }
                if (nx == k) best = dist[k];
            }
        }
    }
}