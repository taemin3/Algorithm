import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int [] parent;
    static int [] size;
    static long [] sum;

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if (ra == rb) return;
        parent[rb] = ra;
        size[ra] += size[rb];
        sum[ra] += sum[rb];
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        size = new int[N + 1];
        sum = new long[N + 1];
        long [] dp = new long[K];

        boolean [] check = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
            sum[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        for (int i = 1 ; i <= N;i++) {
            int r = find(i);
            if (check[r]) continue;
            check[r] = true;

            if (size[r] >= K) continue;
            
            for (int j = K - 1;j >= size[r]; j--) {
                dp[j] = Math.max(dp[j], dp[j - size[r]] + sum[r]);
            }
        }

        System.out.println(dp[K - 1]);

        
        
    }
}